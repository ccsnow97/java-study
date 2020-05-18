package com.cc.study.concurrent.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @Date: 2020/05/18 14:41
 */
public class ParkDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("start thread.");
                LockSupport.park();
                System.out.println("after park.");
                while (true);
            }
        };

        thread.start();
//        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }


}
