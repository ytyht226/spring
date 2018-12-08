package com.jd58.service;

import com.jd58.dao.BookDao;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yanghuitao on 2018/12/7.
 */
@Service
@Data
public class BookService {

//    @Autowired
    @Resource
//    @Inject
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

}