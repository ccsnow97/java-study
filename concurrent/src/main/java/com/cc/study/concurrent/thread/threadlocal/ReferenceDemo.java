package com.cc.study.concurrent.thread.threadlocal;

import lombok.Data;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Date: 2020/05/13 10:28
 */
@Data
public class ReferenceDemo {

    public static String example = "this is example";

    public static ReferenceDemo getReference(){
        return new ReferenceDemo();
    }

    @Override
    public String toString() {
        return example;
    }

    public static void softReference(){
        SoftReference<ReferenceDemo> softReference = new SoftReference<>(getReference());
        System.out.println("soft:"+softReference.get());
    }

    public static void weakReference(){
        WeakReference<ReferenceDemo> weakReference = new WeakReference<>(getReference());
        int count=0;
        System.out.println(weakReference.get());
        while(weakReference.get()!=null){
            count++;
            System.gc();
            System.out.println("Weak reference deleted  after:: " + count + weakReference.get());
        }
    }

    public static void main(String[] args) {
        weakReference();
    }

}
