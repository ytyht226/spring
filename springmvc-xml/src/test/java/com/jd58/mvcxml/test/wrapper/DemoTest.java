package com.jd58.mvcxml.test.wrapper;

import org.junit.Test;
import org.springframework.beans.*;

import java.beans.IntrospectionException;
import java.beans.PropertyEditorSupport;
import java.net.URL;

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

        Wheel wheel = new Wheel();
        wheel.setPosition("position...");

        Driver driver = new Driver();
        driver.setAge(25);
//        BeanWrapper wheelWrapper = new BeanWrapperImpl(wheel);
//        wheelWrapper.setPropertyValue("position", "position...");
//        System.out.println(wheelWrapper.getPropertyValue("position"));
//        System.out.println("wheel: " + wheel);

        Car car = new Car();
        BeanWrapper carWrapper = new BeanWrapperImpl(car);
        carWrapper.registerCustomEditor(String.class, "name", new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(Integer.parseInt(text) * 5);
            }
        });
//        car.setDriver(driver);
//        car.setWheels(Arrays.asList(wheel));

//        Map<String, Wheel> wheelMap = new HashMap<>();
//        wheelMap.put("key1", wheel);
//        carWrapper.setPropertyValue("wheelMap", wheelMap);
        carWrapper.setPropertyValue("name", "1");
        carWrapper.setPropertyValue("wheelMap['key2']", new Wheel("position2"));
        System.out.println("car: " + car);
        System.out.println(carWrapper.getPropertyValue("wheelMap"));
        System.out.println(carWrapper.getPropertyValue("name"));
//        System.out.println(carWrapper.getPropertyValue("wheels[0]"));

//        BeanInfo beanInfo = Introspector.getBeanInfo(Wheel.class);
    }

    @Test
    public void test2() {
        SimpleTypeConverter converter = new SimpleTypeConverter();
        converter.registerCustomEditor(URL.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text.contains("http://")) {
                    text = text.replace("http://", "https://");
                }
                setValue(text);
            }
        });
        URL url = converter.convertIfNecessary("http://www.springframework.org", URL.class);
        System.out.println(url.toString());
    }

}