package com.jd58.test;

import com.jd58.aop.MathCalculator;
import com.jd58.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTestAop {

    @Test
    public void test01() {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathCalculator mathCalculator = ac.getBean(MathCalculator.class);
        mathCalculator.div(5, 5);
    }


}