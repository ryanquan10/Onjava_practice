package com.quan.bean;


import org.springframework.stereotype.Component;

@Component
public class Car {
    public Car() {
        System.out.println("car constructor....");
    }

    /**
     * 专门留给spring 作为一个初始化时候调用的方法
     */
    public void init(){
        System.out.println("car...init...");
    }

    /**
     * 同理
     */
    public void destroy(){
        System.out.println("car   destroy");
    }


}
