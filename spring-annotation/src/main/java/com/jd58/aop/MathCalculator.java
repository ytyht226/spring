package com.jd58.aop;

import com.jd58.bean.Blue;
import com.jd58.bean.Car;

/**
 * Created by yanghuitao on 2018/12/8.
 */
public class MathCalculator implements MathInterface{

//    @Resource
    private Car car;
//    @Autowired
    private Blue blue;

    public int div(int i, int j) {
        System.out.println("car: " + car);
        System.out.println("blue: " + blue);
        return i / j;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setBlue(Blue blue) {
        this.blue = blue;
    }
}