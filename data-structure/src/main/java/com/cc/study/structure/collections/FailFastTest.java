package com.cc.study.structure.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Date: 2020/05/27 17:42
 */
public class FailFastTest {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            list.add(i);
        }

        new ThreadOne().start();
        new ThreadTwo().start();
    }

    static class ThreadOne extends Thread{
        @Override
        public void run() {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){

                Integer next = iterator.next();
                System.out.println(next);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadTwo extends Thread{
        @Override
        public void run() {
            for(int i=0;i<5;i++){
                list.remove(i);
            }
        }
    }
}
