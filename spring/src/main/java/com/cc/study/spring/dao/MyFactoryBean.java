package com.cc.study.spring.dao;

import com.cc.study.spring.TestApplication;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

//@Component
public class MyFactoryBean implements FactoryBean<AccountMapper> {


    @Override
    public AccountMapper getObject() throws Exception {
        AccountMapper accountMapper = (AccountMapper) Proxy.newProxyInstance(TestApplication.class.getClassLoader(),
                new Class[]{AccountMapper.class}, new MyInvocationHandler());
        return accountMapper;
    }

    @Override
    public Class<?> getObjectType() {
        return AccountMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
