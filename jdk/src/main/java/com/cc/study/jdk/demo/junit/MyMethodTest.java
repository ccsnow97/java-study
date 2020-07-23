package com.cc.study.jdk.demo.junit;

/**
 * @Date: 2020/07/23 10:47
 */
public class MyMethodTest {

    @MyBefore
    public void init(){
        System.out.println("初始化...");
    }

    @MyAfter
    public void destory(){
        System.out.println("销毁！");
    }

    @MyTest
    public void printAnimal(String name){
        System.out.println("animal name is: "+name);
    }

    @MyTest
    public void printAnimal(String name,int age){
        System.out.println("animal name is: "+name+", and age is: "+age);
    }

    @MyTest
    public void printFlower(String color){
        System.out.println("flower color is: "+color);
    }

}
