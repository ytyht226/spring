package com.nlu;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.nlu.handler.EventHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@Component
public class ThreadPoolService {
    private static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(2));

    public ThreadPoolService submit(EventHandler... handlers) {
        NluContext context = NluContextHolder.get();
        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for (EventHandler handler : handlers) {
            CompletableFuture<Void> task = CompletableFuture.runAsync(() -> handler.handle(context), executorService);
            tasks.add(task);
        }
        CompletableFuture[] futures = new CompletableFuture[tasks.size()];
        try {
            CompletableFuture.allOf(tasks.toArray(futures)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public ThreadPoolService submit(int timeout, EventHandler... handlers) {
        //todo...
        return this.submit(handlers);
    }
}