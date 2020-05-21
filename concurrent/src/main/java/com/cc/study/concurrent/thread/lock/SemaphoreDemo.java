package com.cc.study.concurrent.thread.lock;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/**
 * @Date: 2020/05/19 14:43
 */
public class SemaphoreDemo {

    //共享锁
    static void test1(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(5);
        for(int i=0;i<20;i++){
            final int INDEX = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        System.out.println(new Date().toString()+"  "+ INDEX);
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        test1();
    }

}
