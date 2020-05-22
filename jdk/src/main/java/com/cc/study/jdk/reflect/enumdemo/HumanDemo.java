package com.cc.study.jdk.reflect.enumdemo;

import com.cc.study.jdk.reflect.HumanState;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @Date: 2020/05/21 14:18
 */
public class HumanDemo {

    void sing(HumanState state) {
        switch (state) {
            case HAPPY:
                System.out.println("sing happy.");
                break;
            case SAD:
                System.out.println("sing sad");
                break;
            default:
                throw new IllegalStateException("Invalid State:" + state);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumBuster<HumanState> buster =
                new EnumBuster<HumanState>(HumanState.class,
                        HumanDemo.class);
        HumanState ANGRY = buster.make("ANGRY");
        buster.addByValue(ANGRY);
        System.out.println(Arrays.toString(HumanState.values()));

        System.out.println(HumanState.values());
        int a=3;

        System.out.println(HumanState.HAPPY.ordinal());
    }

}


