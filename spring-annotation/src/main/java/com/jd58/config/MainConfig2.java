package com.jd58.config;

import com.jd58.bean.Color;
import com.jd58.bean.ColorFactoryBean;
import com.jd58.bean.Person;
import com.jd58.bean.Red;
import com.jd58.condition.LinuxCondition;
import com.jd58.condition.MyImportBeanDefinitionRegistrar;
import com.jd58.condition.MyImportSelector;
import com.jd58.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * Created by yanghuitao on 2018/12/7.
 */
@Configuration
@Conditional({WindowsCondition.class})
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    @Bean("person")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public Person person() {
        System.out.println("add bean to container...");
        return new Person();
    }

    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person person01() {
        return new Person("Bill", 25);
    }

    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person person02() {
        return new Person("linus", 19);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}