package com.jd58.mvcxml.test.editor;

import java.beans.PropertyEditorSupport;

/**
 * Created by yanghuitao on 2019/5/29.
 */
public class CustomCarEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text == null || !text.contains(",")){
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));

        setValue(car);
    }
}