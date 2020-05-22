package com.cc.study.jdk.type;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @Date: 2020/05/21 10:08
 */
public class ClassDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Integer> integerClass = Integer.class;
        Field[] fields = integerClass.getFields();
        Field[] declaredFields = integerClass.getDeclaredFields();
        Constructor<Integer> constructor = integerClass.getConstructor(String.class);
        Integer newInstance = constructor.newInstance("3");
        boolean assignableFrom = integerClass.isAssignableFrom(Number.class);
        boolean assignableFrom1 = Number.class.isAssignableFrom(integerClass);
        Method intValue = integerClass.getMethod("intValue");
        boolean array = integerClass.isArray();
        boolean primitive = integerClass.isPrimitive();
        boolean primitive1 = int.class.isPrimitive();
        String typeName = integerClass.getTypeName();
        Class<?> declaringClass = integerClass.getDeclaringClass();
        String name = integerClass.getName();
        String simpleName = integerClass.getSimpleName();
        Annotation[] annotations = integerClass.getAnnotations();
        Annotation[] declaredAnnotations = integerClass.getDeclaredAnnotations();
        Package aPackage = integerClass.getPackage();
        A a1 = A.class.newInstance();
        AnnotatedType[] annotatedInterfaces = integerClass.getAnnotatedInterfaces();
        AnnotatedType annotatedSuperclass = integerClass.getAnnotatedSuperclass();
        Class<?>[] classes = integerClass.getClasses();
        Class<? super Integer> superclass = integerClass.getSuperclass();
        Class<?>[] interfaces = integerClass.getInterfaces();

        Class<Integer[]> aClass = Integer[].class;
        boolean array1 = aClass.isArray();
        Class<?> componentType = aClass.getComponentType();

        Class<E> eClass = E.class;
        boolean anEnum = eClass.isEnum();
        E[] enumConstants = eClass.getEnumConstants();
        boolean synthetic = eClass.isSynthetic();
        int a=3;
    }

    public static class A{
        int a=3;
    }

    public static enum E{
        ONE(1),
        TWO(2)
        ;

        private int value;

        E(int value) {
            this.value = value;
        }
    }
}
