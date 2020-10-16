package com.cc.study.concurrent.thread.demo.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    /**
     * 商店名称
     */
    private String name;


    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * (阻塞式)通过名称查询价格
     *
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * (非阻塞式)异步获取价格
     *
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            future.complete(price);
        }).start();
        return future;
    }

    /**
     * (非阻塞式)异步获取价格, 使用内部封装方法
     *
     * @param product
     * @return
     */
    public Future<Double> getPriceAsyncOptimize(String product) {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> calculatePrice(product))
//                .exceptionally(e->{
//                    System.out.println("这里可以处理异常");
//                    return -1d;
//                })
                ;
        return future;
    }


    /**
     * 计算价格
     *
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();

        //手动模拟异常
        int i = 1 / 0;

        //数字*字符=数字
        return 10 * product.charAt(0);

    }


    /**
     * 模拟耗时操作,阻塞1秒
     */
    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}