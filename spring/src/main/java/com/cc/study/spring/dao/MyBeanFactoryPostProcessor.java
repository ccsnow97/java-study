package com.cc.study.spring.dao;

import com.cc.study.spring.TestApplication;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AccountMapper accountMapper = (AccountMapper) Proxy.newProxyInstance(TestApplication.class.getClassLoader(),
                new Class[]{AccountMapper.class}, new MyInvocationHandler());
        beanFactory.registerSingleton("accountMapper", accountMapper);
    }
}
