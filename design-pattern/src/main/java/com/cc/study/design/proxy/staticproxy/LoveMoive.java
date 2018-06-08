package com.cc.study.design.proxy.staticproxy;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:37
 * @Modifeid By:
 */
public class LoveMoive implements Movie {
    @Override
    public void play() {
        System.out.println(String.format("playing: %s",this.getClass().getName()));
    }

}
