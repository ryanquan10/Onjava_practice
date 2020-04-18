package com.quan.bean;

import org.springframework.beans.factory.FactoryBean;

public class ShapeFactoryBean implements FactoryBean {

    //返回一个Shape对象,这个对象,这个对象会添加到容器当中
    @Override
    public Object getObject() throws Exception {
        return new Shape();
    }

    //是一个什么对象 因为 getObject返回的是Object
    @Override
    public Class<?> getObjectType() {
        return Shape.class;
    }

    //是否单例
    @Override
    public boolean isSingleton() {
        return false;
    }


}
