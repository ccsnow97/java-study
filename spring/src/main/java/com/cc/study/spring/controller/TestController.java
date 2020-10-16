package com.cc.study.spring.controller;

import com.cc.study.spring.entity.Student;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2020/06/09 11:16
 */
@RestController
@RequestMapping("test")
public class TestController {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Student.class);
        BeanDefinition a = ctx.getBeanFactory().getBeanDefinition("student");
        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("name","tony");
        pvs.add("age",33);
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Student.class,null,pvs);
        ctx.registerBeanDefinition("student",rootBeanDefinition);
        ctx.refresh();
        Object student = ctx.getBean("student");
    }

}
