package com.boot.conditional;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by yanghuitao on 2020/3/29.
 */
@Slf4j
public class OracleDbBean implements DbBean {
    @Override
    public void printInfo() {
        log.info("oracleDbBean...");
    }
}