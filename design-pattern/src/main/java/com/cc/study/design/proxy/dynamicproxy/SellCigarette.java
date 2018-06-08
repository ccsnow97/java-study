package com.cc.study.design.proxy.dynamicproxy;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 下午 01:57
 * @Modifeid By:
 */
public interface SellCigarette {

    default void sellCigarette(){
        System.out.println(String.format("sell cigarette: %s",this.getClass().getSimpleName()));
    }
}
