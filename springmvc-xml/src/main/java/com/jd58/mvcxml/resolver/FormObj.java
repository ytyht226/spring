package com.jd58.mvcxml.resolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yanghuitao on 2018/8/27.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FormObj {
    //参数别名
    String value() default "";
    //是否展示, 默认展示
    boolean show() default true;
}
