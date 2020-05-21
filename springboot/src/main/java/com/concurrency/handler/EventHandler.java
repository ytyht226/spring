package com.concurrency.handler;


import com.concurrency.NluContext;

/**
 * Created by yanghuitao on 2020/2/27.
 */
public interface EventHandler {
    EventHandler handle(NluContext context);

    /**
     * 该handler执行完时，是否可以打断同组的其它handler
     */
    default boolean allowInterruptOthers() {
        return false;
    }

    /**
     * 当前handler优先级，高优先级handler可以打断低优先级handler
     */
    default int getPriority() {
        return Integer.MIN_VALUE;
    }
}
