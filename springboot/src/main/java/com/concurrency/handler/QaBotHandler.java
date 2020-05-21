package com.concurrency.handler;

import com.concurrency.NluContext;
import com.concurrency.model.QaBotResult;
import org.springframework.stereotype.Component;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@Component
public class QaBotHandler implements EventHandler {
    @Override
    public EventHandler handle(NluContext context) {
        System.out.println("QaBotHandler: " + context.getTNluRequest().getQuery());
        QaBotResult result = new QaBotResult();
        result.setResult("qaBotResult...");
        context.setQaBotResult(result);
        return this;
    }
}