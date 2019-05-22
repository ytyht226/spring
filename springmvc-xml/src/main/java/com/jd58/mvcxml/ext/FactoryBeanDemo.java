package com.jd58.mvcxml.ext;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by yanghuitao on 2019/5/21.
 */
@Component
public class FactoryBeanDemo implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new ConfigClazz();
    }

    @Override
    public Class<?> getObjectType() {
        return ConfigClazz.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}