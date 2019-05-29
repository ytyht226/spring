package com.jd58.mvcxml.test.wrapper;

import lombok.Data;

/**
 * Created by yanghuitao on 2019/5/24.
 */
@Data
public class Wheel {
    private String position;

    public Wheel(){}

    public Wheel(String position) {
        this.position = position;
    }
}