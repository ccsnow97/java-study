package com.cc.study.structure.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2020/06/01 11:08
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        ((ArrayList<Integer>) list).ensureCapacity(500);

        int a=3;
    }

    static class Animal{
        Integer age = 3;
    }

    static class Fish extends Animal{
        String fishName = "fish";
    }

}
