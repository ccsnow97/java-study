package com.cc.study.jdk;

/**
 * @Date: 2020/05/13 16:25
 */
public class FinalDemo {
    private int a;  //普通域
    private final int b; //final域
    private static FinalDemo finalDemo;

    public FinalDemo() {
        a = 1; // 1. 写普通域
        b = 2; // 2. 写final域
    }

    public static void writer() {
        finalDemo = new FinalDemo();
    }

    public static void reader() {
        FinalDemo demo = finalDemo; // 3.读对象引用
        int a = demo.a;    //4.读普通域
        int b = demo.b;    //5.读final域
        System.out.println("a="+a+",b="+b);
    }

    public static void main(String[] args) throws InterruptedException {
        new WriteThread().start();
        new ReadThread().start();


        Thread.sleep(2000);
    }

    private static class WriteThread extends Thread{
        @Override
        public void run() {
            writer();
        }
    }

    private static class ReadThread extends Thread{
        @Override
        public void run() {
            reader();
        }
    }
}
