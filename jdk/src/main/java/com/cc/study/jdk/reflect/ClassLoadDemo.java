package com.cc.study.jdk.reflect;

/**
 * @Date: 2020/05/22 16:37
 */
public class ClassLoadDemo {

    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("after create candy");
        try{
            Class.forName("com.cc.study.jdk.reflect.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("can not find Gum");
        }
        System.out.println("after Class forName Gum");
        new Cookie();
        System.out.println("after create Cookie");
    }

}


class Candy{
    static {
        System.out.println("load candy");
    }
}

class Gum{
    static {
        System.out.println("load gum");
    }
}

class Cookie{
    static {
        System.out.println("load cookie");
    }
}
