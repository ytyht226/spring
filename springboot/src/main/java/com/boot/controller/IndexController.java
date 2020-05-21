package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.conditional.DbBean;
import com.boot.config.MyProperties;
import com.boot.service.IAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * Created by yanghuitao on 2020/3/15.
 */
@RestController
@Slf4j
public class IndexController {

    @Resource
    private IAsyncService asyncService;
    @Resource
    private MyProperties myProperties;
    @Resource
    private DbBean dbBean;

    @GetMapping("/index")
    public String index() {
        asyncService.asyncMethod();
        return "boot.";
    }

    @Async
    public void async() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("async in indexController...");
    }

    @RequestMapping("/getConfig")
    public String getConfig() {
        System.out.println("getProperties: " + JSON.toJSONString(myProperties));
        dbBean.printInfo();
        return JSON.toJSONString(myProperties);
    }
}