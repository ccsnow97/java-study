package com.cc.study.design.proxy.staticproxy;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:36
 * @Modifeid By:
 */
public interface Movie {
    default void play(){
        System.out.println(String.format("playing: %s",this.getClass().getName()));
    }
}
