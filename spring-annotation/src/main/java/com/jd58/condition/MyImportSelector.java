package com.jd58.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.jd58.bean.Blue", "com.jd58.bean.Yellow"};
    }
}