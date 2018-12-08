package com.jd58.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yht on 2018/12/8.
 */
@Component
@Data
public class Boss {

    private Car car;

    @Autowired
    public Boss(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}