package com.concurrency.thrift;

import com.concurrency.TNluRequest;

/**
 * Created by yanghuitao on 2020/2/28.
 */
public interface TNluFacade {
    void parse(TNluRequest tNluRequest);

    void getFilterTag(TNluRequest tNluRequest);

    void normalizeSlot(TNluRequest tNluRequest);
}