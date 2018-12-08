package com.jd58.config;

import com.jd58.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by yht on 2018/12/7.
 */
@Configuration
@ComponentScan({"com.jd58.service","com.jd58.dao","com.jd58.controller","com.jd58.bean"})
public class MainConfigAutowired {

    @Bean("bookDao2")
    @Primary
    public BookDao bookDao(){
        BookDao dao = new BookDao();
        dao.setLable("2");
        return dao;
    }
}