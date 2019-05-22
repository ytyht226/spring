package com.jd58.mvcxml.recurse;

import org.springframework.stereotype.Component;

/**
 * Created by yanghuitao on 2019/4/25.
 */
//@Component
public class RecurseDemo4 {

    public RecurseDemo4(RecurseDemo3 recurseDemo3) {
        System.out.println("RecurseDemo4 init..." + recurseDemo3);
    }

}