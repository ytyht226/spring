package com.nlu.handler;


import com.nlu.NluContext;

/**
 * Created by yanghuitao on 2020/2/27.
 */
public interface EventHandler {
    void handle(NluContext context);
}
