package com.jd58.mvcxml.customeditor;


import com.jd58.mvcxml.model.Employee;

import java.beans.PropertyEditorSupport;

/**
 * Created by yht on 2018/8/28.
 */
public class CustomEmployeeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text.indexOf(",") > 0) {
            Employee e = new Employee();
            String[] arr = text.split(",");

            e.setName(arr[0]);
            e.setAge(Integer.parseInt(arr[1]));
            setValue(e);
        } else {
            throw new IllegalArgumentException("employee param is error");
        }
    }
}