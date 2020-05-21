package com.cc.study.concurrent.thread.lock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

/**
 * @Date: 2020/05/18 09:53
 */
public class LockDemo {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Num num = new LockDemo.Num();
        Thread addThread = new Thread(new AddNum(num));
        Thread subThread = new Thread(new SubtractNum(num));
        addThread.start();
        subThread.start();
        addThread.join();
        subThread.join();
        Integer[] integers = {1, 2};
        Stream<Integer> integerStream = Stream.of(integers);
        List<Integer> collect = integerStream.filter(e -> e < 2).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(num.number);
    }

    private static class SubtractNum implements Runnable{
        Num num;
        public SubtractNum(Num num) {
            this.num=num;
        }
        @Override
        public void run() {
            for(int i=0;i<10;i++) {
                lock.lock();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num.number--;
                lock.unlock();
            }
        }
    }

    private static class AddNum implements Runnable{
        Num num;
        public AddNum(Num num) {
            this.num=num;
        }
        @Override
        public void run() {
            for(int i=0;i<10;i++) {
                lock.lock();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num.number++;
                lock.unlock();
            }
        }
    }

    private static class Num{
        Integer number=0;
    }

}
