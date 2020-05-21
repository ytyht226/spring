package com.transaction.example1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yanghuitao on 2020/5/2.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private static String insert_sql = "insert into account(balance) values (100)";
    @Override
    @Transactional
    public void save() throws RuntimeException {
        System.out.println("==开始执行sql");
        jdbcTemplate.update(insert_sql);
        System.out.println("==结束执行sql");

        System.out.println("==准备抛出异常");
//        throw new RuntimeException("==手动抛出一个异常");
    }

    @Override
    public void saveWithoutTx() {
        System.out.println("==开始执行sql");
        jdbcTemplate.update(insert_sql);
        System.out.println("==结束执行sql");

        System.out.println("==准备抛出异常");
        throw new RuntimeException("==手动抛出一个异常");
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}