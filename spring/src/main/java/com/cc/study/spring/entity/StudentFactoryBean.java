package com.cc.study.spring.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Date: 2020/07/22 10:50
 */
@Component
public class StudentFactoryBean implements FactoryBean<Student> {

    @Override
    public Student getObject() throws Exception {
        Student student = new Student();
        student.setName("Tom");
        student.setAge(22);
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

}
