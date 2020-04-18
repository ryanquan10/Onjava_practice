package com.quan.config;

import com.quan.assembly.MyImportSelector;
import com.quan.bean.Color;
import com.quan.bean.Person;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

import static java.rmi.registry.LocateRegistry.getRegistry;

@Configuration
@Import({Color.class, MyImportSelector.class})
public class Config2 {



    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    @Bean("person")
    public Person person(){
        return new Person("luo","yan","youmingxingkong");
    }


    @Conditional({WindowCondition.class})
    @Bean("bill")
    public Person other(){
        return new Person("other","yan","youmingxingkong");
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person another(){
        return new Person("other","yan","youmingxingkong");
    }

//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
//        System.out.println(context.getBean("person")==context.getBean("person"));
//        System.out.println(context.getBean("person").getClass());
//    }



    @Test
    public void test03(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
        String[] names = context.getBeanDefinitionNames();




        Stream.of(names).forEach(e-> System.out.println(e));

//        ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();
//        System.out.println(environment.getProperty("os.name"));

    }
}


class LinuxCondition implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String os =  conditionContext.getEnvironment().getProperty("os.name");
        if(os.contains("liunx"))
            return true;

        return false;
    }
}


class WindowCondition implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //TODO是否linux系统
        //1.能否获得到 ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory =conditionContext.getBeanFactory();

        //获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        Environment environment = conditionContext.getEnvironment();

        //获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");
        if(property.contains("Windows"))
            return true;

        return false;
    }
}

