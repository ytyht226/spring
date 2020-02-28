package com.nlu;

import lombok.Data;
import com.nlu.model.ChitModelResult;
import com.nlu.model.DomainSortResult;
import com.nlu.model.QaBotResult;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@Data
public class NluContext {
    private TNluRequest tNluRequest;
    /**
     * 领域分类结果
     */
    private DomainSortResult domainSortResult;
    /**
     * qabot结果
     */
    private QaBotResult qaBotResult;
    /**
     * 闲聊结果
     */
    private ChitModelResult chitModelResult;
}