package com.jd58.mvcxml.recurse;

import org.springframework.stereotype.Component;

/**
 * Created by yanghuitao on 2019/4/25.
 */
//@Component
public class RecurseDemo3 {

    public RecurseDemo3(RecurseDemo4 recurseDemo4) {
        System.out.println("RecurseDemo3 init..." + recurseDemo4);
    }

}