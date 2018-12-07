package com.jd58.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}