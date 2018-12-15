package com.jd58.config;

import com.jd58.bean.CircularityA;
import com.jd58.bean.CircularityB;
import com.jd58.ext.MyBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yht on 2018/12/15.
 */
@Configuration
public class MainConfigOfCircular {
    @Bean
    public CircularityA circularityA() {
        return new CircularityA();
    }

    @Bean
    public CircularityB circularityB() {
        return new CircularityB();
    }

//    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }
}