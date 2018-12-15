package com.jd58.config;

import com.jd58.aop.LogAspects;
import com.jd58.aop.MathCalculator;
import com.jd58.aop.MathInterface;
import com.jd58.bean.Blue;
import com.jd58.bean.Car;
import com.jd58.ext.MyBeanFactoryPostProcessor;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by yanghuitao on 2018/12/8.
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAop {

    @Bean(autowire = Autowire.BY_NAME)
    public MathInterface mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public Car car0() {
        return new Car();
    }

    @Bean
    public Car car() {
        return new Car();
    }

    @Bean
    public Blue blue() {
        return new Blue();
    }


//    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }
}
