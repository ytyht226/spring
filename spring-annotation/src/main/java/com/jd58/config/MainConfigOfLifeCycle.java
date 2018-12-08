package com.jd58.config;

import com.jd58.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yht on 2018/12/7.
 */
@Configuration
@ComponentScan("com.jd58.bean")
public class MainConfigOfLifeCycle {


    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}