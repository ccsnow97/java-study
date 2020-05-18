package com.cc.study.concurrent.thread.threadlocal;

import lombok.Data;

/**
 * @Date: 2020/05/12 13:47
 */
@Data
public class Test {

    private ThreadLocal<Integer> num= new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {
        int a=16;
        int b=3>>>a;
        System.out.println(b);

    }

    public class A {
        private int some;
        public int another;

        public int getSome() { return some; }
        public synchronized int getSomeWithSync() { return some; }
        public void setSome(int v) { some = v; }
        public synchronized void setSomeWithSync(int v) { some = v; }
    }

}
