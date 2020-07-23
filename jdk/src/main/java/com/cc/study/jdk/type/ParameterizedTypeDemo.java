package com.cc.study.jdk.type;

import com.cc.study.jdk.MyAnnotation;
import com.sun.istack.internal.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Date: 2020/05/20 14:26
 */
public class ParameterizedTypeDemo<T> {

    List<T> list = null;
    Set<T> set = null;
    @MyAnnotation
    Map.Entry<T,Integer> entry;

    public static void main(String[] args) throws NoSuchFieldException {

        Field field = ParameterizedTypeDemo.class.getDeclaredField("entry");
        Type genericType = field.getGenericType();
        Class<?> type = field.getType();
        int modifiers = field.getModifiers();
        String name = field.getName();
        Class<?> declaringClass = field.getDeclaringClass();
        Annotation[] annotations = field.getAnnotations();
        MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
        if(genericType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            Type ownerType = parameterizedType.getOwnerType();
            int a=3;
        }
        Class<? extends Type> aClass = genericType.getClass();
        System.out.println(aClass.getName());
    }

}
