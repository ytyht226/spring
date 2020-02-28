package com.nlu.thrift;

import com.nlu.handler.ChitModelHandler;
import com.nlu.handler.DomainSortHandler;
import com.nlu.handler.QaBotHandler;
import com.nlu.NluContextHolder;
import com.nlu.TNluRequest;
import com.nlu.ThreadPoolService;
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