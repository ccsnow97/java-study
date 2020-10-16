package com.cc.study.spring;

import com.cc.study.spring.dao.AccountMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cc.study.spring.*")
//@EnableTransactionManagement
//@MyMapperScan
public class TestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        AccountMapper accountMapper = (AccountMapper) applicationContext.getBean("accountMapper");

        accountMapper.query();
//
//        AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);
//        System.out.println(accountMapper.query());
    }

}
