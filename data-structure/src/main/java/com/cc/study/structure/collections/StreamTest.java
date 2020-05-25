package com.cc.study.structure.collections;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Date: 2020/05/25 14:40
 */
public class StreamTest {

    public static void main(String[] args) {
        Stream.of(1,2);

        Object obj = Stream.of(1, 2, 3, 4)
                .collect(Collector.of((Supplier<List<Integer>>) ArrayList::new,
                        List::add,
                        (o, o2) -> null,Collector.Characteristics.CONCURRENT));

        ArrayList<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toCollection(ArrayList::new));
        
        String collect1 = Stream.of("a", "b", "c", "d").collect(Collectors.joining());
        String collect2 = Stream.of("a", "b", "c", "d").collect(Collectors.collectingAndThen((Collectors.mapping(e -> e.toUpperCase(), Collectors.toList())),
                a -> a.toString()));

        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        stringJoiner.add("today");
        stringJoiner.add("is");

        StringJoiner stringJoiner1 = new StringJoiner(",", "[", "}");
        stringJoiner1.add("saturdy");
        stringJoiner1.add("aa");

        stringJoiner.merge(stringJoiner1);
        String s = stringJoiner.toString();


        int a=3;
    }

}
