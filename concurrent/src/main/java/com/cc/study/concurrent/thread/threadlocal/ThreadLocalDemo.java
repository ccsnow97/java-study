package com.cc.study.concurrent.thread.threadlocal;

/**
 * @Date: 2020/05/13 17:39
 */
public class ThreadLocalDemo {

    private ThreadLocal<Integer> baseYear = new ThreadLocal<>();

    private String addMonth(Integer month){
        baseYear.set(2000);
        return month.toString();
    }

    private String addAge(Integer age,String month){
        int i = baseYear.get() + age;
        return i+"-"+month;
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        String s = demo.addAge(23, demo.addMonth(8));
        System.out.println(s);
    }

}
