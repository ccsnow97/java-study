package com.cc.study.design.proxy.staticproxy;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:39
 * @Modifeid By:
 */
public class ActMovie implements Movie{
    public static void main(String[] args) {
        Movie actMovie=new ActMovie();
        actMovie.play();
    }
}
