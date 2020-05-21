package com.cc.study.jdk.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * @Date: 2020/05/20 15:39
 */
public class WildcardTypeDemo {

    List<? extends String> list;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = WildcardTypeDemo.class.getDeclaredField("list");
        Type genericType = field.getGenericType();
        if(genericType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            WildcardType wildcardType = (WildcardType) actualTypeArgument;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            int a=3;
        }
        int a=3;
    }
}
