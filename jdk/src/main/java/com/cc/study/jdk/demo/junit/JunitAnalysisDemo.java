package com.cc.study.jdk.demo.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date: 2020/07/23 10:50
 */
public class JunitAnalysisDemo {

    public static void runMethod(Object obj, String methodName, Object... args) throws InvocationTargetException, IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Method[] methods = aClass.getMethods();
        //before method
        List<Method> beforeMethods = Arrays.stream(methods).filter(e -> {
            MyBefore annotation = e.getAnnotation(MyBefore.class);
            return annotation != null;
        }).collect(Collectors.toList());
        //after method
        List<Method> afterMethods = Arrays.stream(methods).filter(e -> {
            MyAfter annotation = e.getAnnotation(MyAfter.class);
            return annotation != null;
        }).collect(Collectors.toList());

        for (Method method : methods) {
            int argsCount = args == null ? 0 : args.length;
            if (method.getName().equals(methodName) && argsCount == method.getParameterCount()) {

                if(method.getAnnotation(MyTest.class)!=null){
                    for(Method beforeMethod:beforeMethods){
                        beforeMethod.invoke(obj);
                    }
                    method.invoke(obj,args);
                    for(Method afterMethod:afterMethods){
                        afterMethod.invoke(obj);
                    }
                }else {
                    method.invoke(obj, args);
                }
                break;
            }
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyMethodTest myMethodTest = new MyMethodTest();

        runMethod(myMethodTest,"printAnimal","dog",3);

        runMethod(myMethodTest,"printFlower","red");
    }

}
