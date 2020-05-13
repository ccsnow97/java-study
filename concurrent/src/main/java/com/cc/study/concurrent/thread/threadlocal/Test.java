package com.cc.study.concurrent.thread.threadlocal;

import lombok.Data;

/**
 * @Date: 2020/05/12 13:47
 */
@Data
public class Test {

    private ThreadLocal<Integer> num= new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程完了");
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
//        thread.join();
        Thread.sleep(2500);
        System.out.println("main线程完了");
    }

}
