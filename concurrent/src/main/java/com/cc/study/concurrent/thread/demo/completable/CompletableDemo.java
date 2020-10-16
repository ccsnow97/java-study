package com.cc.study.concurrent.thread.demo.completable;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableDemo {

    private long divisor = 1_000_000;

    @Test
    public void testGetPrice() {
        Shop shop = new Shop("goods");
        long start = System.nanoTime();
        double price = shop.getPrice("glove");
        long innovationTime = (System.nanoTime() - start) / divisor;
        System.out.println("调用时间：" + innovationTime);
        doSomethingElse();
        long totalTime = (System.nanoTime() - start) / divisor;
        System.out.println("总时间：" + totalTime);
    }

    @Test
    public void testAsync() throws ExecutionException, InterruptedException {
        Shop shop = new Shop("goods");
        long start = System.nanoTime();
        Future<Double> price = shop.getPriceAsync("glove");
        long innovationTime = (System.nanoTime() - start) / divisor;
        System.out.println("调用时间：" + innovationTime);
        doSomethingElse();
        Double res = price.get();
        System.out.println("结果是：" + res);
        long totalTime = (System.nanoTime() - start) / divisor;
        System.out.println("总时间：" + totalTime);
    }

    @Test
    public void testAsyncOptimize() throws ExecutionException, InterruptedException {
        Shop shop = new Shop("goods");
        long start = System.nanoTime();
        Future<Double> price = shop.getPriceAsyncOptimize("glove");
        long innovationTime = (System.nanoTime() - start) / divisor;
        System.out.println("调用时间：" + innovationTime);
        doSomethingElse();
        try {
            Double res = price.get();
            System.out.println("结果是：" + res);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            System.out.println(e);
        }
        long totalTime = (System.nanoTime() - start) / divisor;
        System.out.println("总时间：" + totalTime);
    }

    /**
     * 其它操作
     */
    public static void doSomethingElse() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
