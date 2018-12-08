package com.jd58.controller;

import com.jd58.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by yanghuitao on 2018/12/7.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}