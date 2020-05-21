package com.cc.study.concurrent.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2020/05/19 15:03
 */
public class ConditionDemo {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConditionDemo demo = new ConditionDemo();
        Consumer consumer = demo.new Consumer();
        Produce produce = demo.new Produce();
        consumer.start();
        produce.start();

    }

    class Consumer extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println("进入lock：" + Thread.currentThread().getName());
            try {
                System.out.println("进入await：" + Thread.currentThread().getName());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("离开await：" + Thread.currentThread().getName());
            lock.unlock();
            System.out.println("离开lock：" + Thread.currentThread().getName());
        }
    }

    class Produce extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println("进入lock：" + Thread.currentThread().getName());
            System.out.println("进入signal：" + Thread.currentThread().getName());
            condition.signal();
            System.out.println("离开signal：" + Thread.currentThread().getName());
            lock.unlock();
            System.out.println("离开lock：" + Thread.currentThread().getName());
        }
    }
}
