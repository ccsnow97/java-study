package com.cc.study.polymorphism;

/**
 * @Author: hecongcong
 * @Description:
 * @Date: 2018/6/6 10:41
 * @Modifeid By:
 */
public class ThisDemo {

    public static void main(String[] args) {
        SubA subA=new SubA();
        subA.write();

    }

    private static class Parent{
        public void write(){
            System.out.println("Parent:"+this.getClass().getName());
        }
    }

    private static class SubA extends Parent{
//        @Override
//        public void write() {
//            System.out.println("SubA:"+this.getClass().getName());
//        }
    }
}
