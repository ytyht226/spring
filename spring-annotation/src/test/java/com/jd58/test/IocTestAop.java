package com.jd58.test;

import com.jd58.aop.MathInterface;
import com.jd58.bean.CircularityA;
import com.jd58.bean.CircularityB;
import com.jd58.config.MainConfigOfAop;
import com.jd58.config.MainConfigOfCircular;
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
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\class");
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
//        MathInterface mathCalculator = ac.getBean(MathInterface.class);
//        mathCalculator.div(5, 5);
//        mathCalculator.div(15, 5);
    }

    @Test
    public void test02() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\class");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfCircular.class);
        CircularityA circularityA = ac.getBean(CircularityA.class);
        CircularityB circularityB = ac.getBean(CircularityB.class);
        System.out.println(circularityA);
        System.out.println(circularityB);

    }

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\class");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathInterface mathCalculator = ac.getBean(MathInterface.class);
        mathCalculator.div(5, 5);
    }

}