package com.concurrency;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.concurrency.handler.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@Component
@Slf4j
public class ThreadPoolService {
    private static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(2));

    public ThreadPoolService submit(int timeout, EventHandler... handlers) {
        if (null == handlers || handlers.length == 0) {
            return this;
        }

        //handler状态map
        ConcurrentHashMap<EventHandler, Boolean> handlerStateMap = new ConcurrentHashMap<>();
        //具体相同优先级的map
        Map<Integer, List<EventHandler>> samePriorityMap = new HashMap<>();
        //执行handler的thread集合
        CopyOnWriteArrayList<Thread> handlerThreads = new CopyOnWriteArrayList<>();

        NluContext context = NluContextHolder.get();
        List<CompletableFuture<EventHandler>> tasks = new ArrayList<>();
        for (EventHandler handler : handlers) {
            //允许打断其它线程
            if (handler.allowInterruptOthers()) {
                handlerStateMap.put(handler, false);
                if (samePriorityMap.containsKey(handler.getPriority())) {
                    samePriorityMap.get(handler.getPriority()).add(handler);
                } else {
                    List<EventHandler> samePriorityList = new ArrayList<>();
                    samePriorityList.add(handler);
                    samePriorityMap.put(handler.getPriority(), samePriorityList);
                }
            }
            CompletableFuture<EventHandler> task = CompletableFuture.supplyAsync(() -> {
                Thread currThread = Thread.currentThread();
                handlerThreads.add(currThread);
                //线程调用时添加try...catch 避免具体的handler没有catch影响其它handler的执行
                try {
                    return handler.handle(context);
                } catch (Throwable e) {
                    log.error("handler process error ", e);
                }
                return handler;
            }, executorService)
                    .whenComplete((eventHandler, throwable) -> {
                        if (null != throwable) {
                            log.error("线程执行失败 error ", throwable);
                        } else {
                            //允许打断其它线程
                            handlerStateMap.put(eventHandler, true);
                            interruptOtherGroupThreads(eventHandler, handlerStateMap, samePriorityMap, handlerThreads);
                        }
                    });
            tasks.add(task);
        }
        try {
            CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).get(timeout, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error("线程池执行失败 error ", e);
        }
        return this;
    }

    public ThreadPoolService submit(EventHandler... handlers) {
        return this.submit(200, handlers);
    }

    /**
     * 打断同一线程组中其它未执行完的线程
     */
    private void interruptOtherGroupThreads(EventHandler currHandler, Map<EventHandler, Boolean> handlerStateMap, Map<Integer, List<EventHandler>> samePriorityMap, List<Thread> handlerThreads) {
        try {
            //当前handler不能打断其它handler
            if (null == currHandler || !currHandler.allowInterruptOthers()) {
                return;
            }
            //当前handler优先级不是最高的
            Integer maxPriority = samePriorityMap.keySet().stream().max(Integer::compareTo).orElse(Integer.MAX_VALUE);
            if (currHandler.getPriority() < maxPriority) {
                return;
            }
            //判断具有相同优先级的其它handler是否完成
            List<EventHandler> eventHandlers = samePriorityMap.get(currHandler.getPriority());
            Optional<EventHandler> unFinished = eventHandlers.stream().filter(e -> !handlerStateMap.get(e)).findFirst();
            if (unFinished.isPresent()) {
                return;
            }
            //当前线程执行完时 还有未启动的线程 则当前线程暂停一下
            if (handlerThreads.size() < handlerStateMap.size()) {
                Thread.yield();
            }
            //打断其它handler对应的线程
            for (Thread thread : handlerThreads) {
                if (Thread.currentThread() == thread) {
                    continue;
                }
                thread.interrupt();
            }
        } catch (Exception e) {
            log.error("interruptOtherGroupThreads error ", e);
        }
    }
}