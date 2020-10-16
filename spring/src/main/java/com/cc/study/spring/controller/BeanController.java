package com.cc.study.spring.controller;

import com.cc.study.spring.entity.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2020/07/21 16:55
 */
@RestController
@RequestMapping("bean")
public class BeanController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getName(@RequestParam String name) throws JsonProcessingException {
        Object bean = beanFactory.getBean(name);
        if(bean!=null) {
            String res = bean.getClass().getName();
            return res;
        }else {
            return null;
        }
    }

    @GetMapping("test")
    public String test() {
        String studentServiceName = studentService.getName();
        String name = studentService.getClass().getName();
        return name;
    }
}
