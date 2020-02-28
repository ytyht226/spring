package com.nlu.handler;

import com.nlu.NluContext;
import com.nlu.model.DomainSortResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@Component
public class DomainSortHandler implements EventHandler {
    @Override
    public void handle(NluContext context) {
        System.out.println("DomainSortHandler: " + context.getTNluRequest().getQuery());
        DomainSortResult result = new DomainSortResult();
        result.setResult("domainSortResult...");
        context.setDomainSortResult(result);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}