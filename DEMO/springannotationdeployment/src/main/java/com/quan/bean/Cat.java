package com.quan.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat constructor...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
     //创建完成并且属性值都赋值后进行调用  (构造函数之后)
        System.out.println("cat...init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destroy");
    }
}
