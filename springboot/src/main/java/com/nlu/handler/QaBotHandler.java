package com.nlu.handler;

import com.nlu.NluContext;
import com.nlu.model.QaBotResult;
import org.springframework.stereotype.Component;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@Component
public class QaBotHandler implements EventHandler {
    @Override
    public void handle(NluContext context) {
        System.out.println("QaBotHandler: " + context.getTNluRequest().getQuery());
        QaBotResult result = new QaBotResult();
        result.setResult("qaBotResult...");
        context.setQaBotResult(result);
    }
}