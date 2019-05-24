package com.jd58.mvcxml.wrapper;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * Created by yanghuitao on 2019/5/24.
 */
public class DemoTest {
    @Test
    public void test() throws IntrospectionException {
//        //左边轮子的BeanWrapper
//        Wheel leftWheel = new Wheel();
//        BeanWrapper beanWrapperOfLeftWheel = PropertyAccessorFactory.forBeanPropertyAccess(leftWheel);
//        PropertyValue leftPosition = new PropertyValue("position", "左边");
//        beanWrapperOfLeftWheel.setPropertyValue(leftPosition);
//        System.out.println(beanWrapperOfLeftWheel.getWrappedInstance());
//
//        //右边轮子的BeanWrapper
//        Wheel rightWheel = new Wheel();
//        BeanWrapper beanWrapperOfRightWheel = PropertyAccessorFactory.forBeanPropertyAccess(rightWheel);
//        PropertyValue rightPosition = new PropertyValue("position", "右边");
//        beanWrapperOfRightWheel.setPropertyValue(rightPosition);
//        System.out.println(beanWrapperOfRightWheel.getWrappedInstance());
//
//        // 驾驶员
//        Driver driver = new Driver();
//        BeanWrapper beanWrapperOfDriver = PropertyAccessorFactory.forBeanPropertyAccess(driver);
//        PropertyValue age = new PropertyValue("age", 20);
//        beanWrapperOfDriver.setPropertyValue(age);
//        System.out.println(beanWrapperOfDriver.getWrappedInstance());
//
//
//        // 车子
//        Car car = new Car();
//        BeanWrapper beanWrapperOfCar = PropertyAccessorFactory.forBeanPropertyAccess(car);
//        beanWrapperOfCar.setPropertyValue("name", "奔驰"); // 车名
//        Wheel[] wheels = {leftWheel, rightWheel}; //轮子数组
//        beanWrapperOfCar.setPropertyValue("wheels", wheels); //轮子
//        beanWrapperOfCar.setPropertyValue("driver", driver); //驾驶员
//        System.out.println(beanWrapperOfCar.getWrappedInstance());
//
//        // 获取驾驶员的年龄
//        int retrievedAge = (Integer) beanWrapperOfCar.getPropertyValue("driver.age");
//        System.out.println("driver age : " + retrievedAge);
//
//
//        // 通过表达式间接设置car的wheel的width
//        beanWrapperOfCar.setPropertyValue("wheels[0].position", "修改过的左边");
//        System.out.println(beanWrapperOfCar.getWrappedInstance());

//        Wheel wheel = new Wheel();
//        wheel.setPosition("position...");
//        BeanWrapper wheelWrapper = new BeanWrapperImpl(wheel);
//        System.out.println(wheelWrapper.getPropertyValue("position"));

        BeanInfo beanInfo = Introspector.getBeanInfo(Wheel.class);
    }
}