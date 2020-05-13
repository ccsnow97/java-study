package com.cc.study.concurrent.thread.threadlocal;

/**
 * @Date: 2020/05/13 11:16
 */
public class InterruptDemo {

    public static void main(String[] args) {
        Thread sleepThread = new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread busyThread  = new Thread(){
            @Override
            public void run() {
                while (true){}
            }
        };

        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while(sleepThread.isInterrupted()){}
        System.out.println("sleep:"+sleepThread.isInterrupted());
        System.out.println("busy: "+busyThread.isInterrupted());
    }

}
