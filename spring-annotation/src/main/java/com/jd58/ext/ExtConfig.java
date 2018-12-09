package com.jd58.ext;

import com.jd58.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yht on 2018/12/9.
 */
@Configuration
@ComponentScan("com.jd58.ext")
public class ExtConfig {

    @Bean
    public Car blue() {
        return new Car();
    }

}