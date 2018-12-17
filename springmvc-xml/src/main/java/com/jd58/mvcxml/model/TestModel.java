package com.jd58.mvcxml.model;

import lombok.Data;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yht on 2018/8/28.
 */
@Data
public class TestModel {
    private int age;
    private Date birth;
    private String name;
    private boolean good;
    private long times;

    public static void main(String[] args) {
        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        bw.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        bw.setPropertyValue("good", true);
        bw.setPropertyValue("birth", "1990-01-01");
        System.out.println(tm);
    }
}