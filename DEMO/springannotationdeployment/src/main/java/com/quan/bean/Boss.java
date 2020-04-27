package com.quan.config;

import com.quan.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
    private Car car;


    public Car getCar() {
        return car;
    }

    /**
     *
     * @param car
     * 方法使用的参数,自定义类型的值从ioc容器中获取
     */
    @Autowired //标注在此处,Spring容器创建当前对象,就会调用方法,完成赋值
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
