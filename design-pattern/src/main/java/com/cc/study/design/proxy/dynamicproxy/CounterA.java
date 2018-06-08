package com.cc.study.design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:57
 * @Modifeid By:
 */
public class CounterA implements InvocationHandler {

    private Object sellWine;

    public CounterA(Object sellWine){
        this.sellWine=sellWine;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("sell begin, counter is: "+this.getClass().getSimpleName());
        method.invoke(sellWine,args);
        System.out.println("sell end.");
        return null;
    }
}
