package com.cc.study.design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 下午 12:02
 * @Modifeid By:
 */
public class Main {
    public static void main(String[] args) {

        SellWine sellWine = new MaotaiWine();
        InvocationHandler counterA = new CounterA(sellWine);
        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(sellWine.getClass().getClassLoader(),
                sellWine.getClass().getInterfaces(), counterA);
        dynamicProxy.sellwine();


        System.out.println("---------------------");

        sellWine=new WuliangyeWine();
        counterA=new CounterA(sellWine);
        dynamicProxy = (SellWine) Proxy.newProxyInstance(sellWine.getClass().getClassLoader(),
                sellWine.getClass().getInterfaces(), counterA);
        dynamicProxy.sellwine();

        System.out.println("---------------------");

        SellCigarette sellCigarette=new ZhonghuaCigarette();
        counterA=new CounterA(sellCigarette);
        SellCigarette cigaretteDynamicProxy=(SellCigarette)Proxy.newProxyInstance(sellCigarette.getClass().getClassLoader(),
                sellCigarette.getClass().getInterfaces(), counterA);
        cigaretteDynamicProxy.sellCigarette();
    }
}
