package com.concurrency.handler;


import com.concurrency.NluContext;
import com.concurrency.model.ChitModelResult;
import org.springframework.stereotype.Component;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@Component
public class ChitModelHandler implements EventHandler {
    @Override
    public EventHandler handle(NluContext context) {
        System.out.println("ChitModelHandler: " + context.getTNluRequest().getQuery());
        ChitModelResult result = new ChitModelResult();
        //todo...
        result.setResult("chitModelResult...");
        context.setChitModelResult(result);
        return this;
    }
}