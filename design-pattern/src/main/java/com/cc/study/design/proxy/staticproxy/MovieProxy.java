package com.cc.study.design.proxy.staticproxy;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/7 上午 11:44
 * @Modifeid By:
 */
public class MovieProxy implements Movie{
    private Movie movie;
    public MovieProxy(Movie movie){
        this.movie=movie;
    }

    @Override
    public void play() {
        System.out.println("movie proxy: play before");
        movie.play();
        System.out.println("movie proxy: play after");
    }
}
