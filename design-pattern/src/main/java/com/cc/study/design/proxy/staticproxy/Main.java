package com.cc.study.design.proxy.staticproxy;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:45
 * @Modifeid By:
 */
public class Main {
    public static void main(String[] args) {
        Movie movie=new MovieProxy(new ActMovie());
        movie.play();
        System.out.println("------------");
        movie=new MovieProxy(new LoveMoive());
        movie.play();
    }
}
