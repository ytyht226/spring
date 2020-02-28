package com.nlu.thrift;

import com.nlu.TNluRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by yanghuitao on 2020/2/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TNluFacadeImplTest {

    @Resource
    private TNluFacade tNluFacade;
    @Test
    public void parse() {
        TNluRequest tNluRequest = new TNluRequest("query test...");
        tNluFacade.parse(tNluRequest);
    }
}