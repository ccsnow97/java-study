package com.cc.study.jdk.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Date: 2020/05/21 14:48
 */
public class ReflectDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Sing sing = new Sing();

        Method singMethod = Sing.class.getDeclaredMethod("sing");
        singMethod.setAccessible(true);
        singMethod.invoke(new Sing());

        Field ageField = Sing.class.getDeclaredField("age");
        ageField.setAccessible(true);
        Field modifiersField = ageField.getClass().getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        int modifiersInt = modifiersField.getInt(ageField);
        modifiersInt &= ~Modifier.FINAL;
        modifiersField.setInt(ageField,modifiersInt);
        ageField.setInt(sing,10);
        int a =3;
    }

    static class Sing{
        private final int age =6;
        private static void sing(){
            System.out.println("sing.....");
        }
    }
}


