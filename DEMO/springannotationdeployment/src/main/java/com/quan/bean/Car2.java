package com.quan.bean;

import org.springframework.stereotype.Component;

@Component
public class Car2 {
    public Car2() {
        System.out.println("car2 constructor....");
    }

    /**
     * 专门留给spring 作为一个初始化时候调用的方法
     */
    public void init(){
        System.out.println("car2...init...");
    }

    /**
     * 同理
     */
    public void destroy(){
        System.out.println("car2   destroy");
    }


}
