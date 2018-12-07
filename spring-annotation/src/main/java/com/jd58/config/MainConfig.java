package com.jd58.config;

import com.jd58.bean.Person;
import org.springframework.context.annotation.*;

/**
 * Created by yanghuitao on 2018/12/7.
 */
@Configuration
//@ComponentScan(value = "com.jd58", useDefaultFilters = false, includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//})
@ComponentScans(value = {
        @ComponentScan(value = "com.jd58", useDefaultFilters = false, includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        })
})
public class MainConfig {
    @Bean("person")
    public Person person() {
        return new Person("lisi", 20);
    }
}