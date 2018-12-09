package com.jd58.condition;

import com.jd58.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by yht on 2018/12/8.
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean containRed = registry.containsBeanDefinition("com.jd58.bean.Red");
        boolean containBlue = registry.containsBeanDefinition("com.jd58.bean.Blue");
        if (containRed && containBlue) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}