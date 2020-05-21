package com.concurrency.thrift;

import com.concurrency.handler.ChitModelHandler;
import com.concurrency.handler.DomainSortHandler;
import com.concurrency.handler.QaBotHandler;
import com.concurrency.NluContextHolder;
import com.concurrency.TNluRequest;
import com.concurrency.ThreadPoolService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by yanghuitao on 2020/2/28.
 */
@Component
public class TNluFacadeImpl implements TNluFacade {
    @Resource
    private ThreadPoolService threadPoolService;
    @Resource
    private DomainSortHandler domainSortHandler;
    @Resource
    private QaBotHandler qaBotHandler;
    @Resource
    private ChitModelHandler chitModelHandler;


    @Override
    public void parse(TNluRequest tNluRequest) {
        //todo...
        threadPoolService.submit(domainSortHandler, qaBotHandler, chitModelHandler).submit(chitModelHandler);



        //todo...
        System.out.println(NluContextHolder.get());
        //
    }



    @Override
    public void getFilterTag(TNluRequest tNluRequest) {

    }

    @Override
    public void normalizeSlot(TNluRequest tNluRequest) {

    }
}