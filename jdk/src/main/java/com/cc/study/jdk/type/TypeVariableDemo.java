package com.cc.study.jdk.type;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date: 2020/05/20 15:06
 */
public class TypeVariableDemo<T extends Number & Comparable> {

    T list;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = TypeVariableDemo.class.getDeclaredField("list");
        Type genericType = field.getGenericType();
        Class<?> type = field.getType();
        if(genericType instanceof TypeVariable){
            TypeVariable typeVariable = (TypeVariable) genericType;
            AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();
            List<Type> collect = Arrays.stream(annotatedBounds).map(e -> e.getType()).collect(Collectors.toList());
            Type[] bounds = typeVariable.getBounds();
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            String name = typeVariable.getName();
            int  a=3;
        }
    }
}
