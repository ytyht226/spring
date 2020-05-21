package com.concurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by yanghuitao on 2020/2/28.
 */
@SpringBootApplication(scanBasePackages = "com.concurrency", exclude={DataSourceAutoConfiguration.class})
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}