package com.cc.study.jdk.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Date: 2020/05/20 14:56
 */
public class GenericArrayTypeDemo<T> {

    T[] strings;
    List<String>[] listArray;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = GenericArrayTypeDemo.class.getDeclaredField("strings");
        Type genericType = field.getGenericType();
        Class<?> type = field.getType();
        System.out.println(type.getClass().getName());
        if(genericType instanceof GenericArrayType){
            GenericArrayType arrayType = (GenericArrayType) genericType;
            Type genericComponentType = arrayType.getGenericComponentType();
            int a=3;
        }else {
            int a = 3;
        }
    }

}
