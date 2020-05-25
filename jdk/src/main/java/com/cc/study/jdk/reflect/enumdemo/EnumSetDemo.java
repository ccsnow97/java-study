package com.cc.study.jdk.reflect.enumdemo;

import java.lang.reflect.Field;
import java.util.EnumSet;

/**
 * @Date: 2020/05/22 14:33
 */
public class EnumSetDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        EnumSet<Color> colorEnumSet = EnumSet.noneOf(Color.class);
        Class<? extends EnumSet> aClass = colorEnumSet.getClass();
        Class<?> superclass = aClass.getSuperclass();
        Field universeField = superclass.getDeclaredField("universe");
        universeField.setAccessible(true);
        Object o = universeField.get(colorEnumSet);

        colorEnumSet.add(Color.GREEN);
        System.out.println(colorEnumSet.toString());
        int a=3;

    }


    static enum Color{
        RED,GREEN
    }

}
