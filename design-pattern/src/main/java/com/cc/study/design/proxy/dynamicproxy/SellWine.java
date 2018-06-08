package com.cc.study.design.proxy.dynamicproxy;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:52
 * @Modifeid By:
 */
public interface SellWine {
    default void sellwine(){
        System.out.println(String.format("sell wine: %s",this.getClass().getSimpleName()));
    }
}
