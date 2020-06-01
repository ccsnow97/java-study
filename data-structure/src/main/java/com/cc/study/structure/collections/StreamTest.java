package com.cc.study.structure.collections;

import lombok.Data;

import java.io.ObjectInputStream;
import java.util.*;
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
        Stream.of(1, 2);

        Object obj = Stream.of(1, 2, 3, 4)
                .collect(Collector.of((Supplier<List<Integer>>) ArrayList::new,
                        List::add,
                        (o, o2) -> null, Collector.Characteristics.CONCURRENT));

        ArrayList<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toCollection(ArrayList::new));

        String collect1 = Stream.of("a", "b", "c", "d").collect(Collectors.joining());
        String collect2 = Stream.of("a", "b", "c", "d").collect(Collectors.collectingAndThen((Collectors.mapping(e -> e.toUpperCase(), Collectors.toList())),
                a -> a.toString()));

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("today");
        stringJoiner.add("is");

        StringJoiner stringJoiner1 = new StringJoiner(",", "[", "}");
        stringJoiner1.add("saturdy");
        stringJoiner1.add("aa");

        stringJoiner.merge(stringJoiner1);
        String s = stringJoiner.toString();

        List<Student> list = new ArrayList<>();
        list.add(new Student(12, 133, 45));
        list.add(new Student(12, 133, 46));
        list.add(new Student(12, 131, 43));
        list.add(new Student(10, 133, 45));

        testGroup(list);

        int a = 3;
    }

    static void testGroup(List<Student> list) {
        Map<Integer, Map<Integer, List<Student>>> collect = list.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.groupingBy(Student::getHeitht,
                        Collectors.mapping(e -> {
                            e.setWeight(e.getWeight() + 1000);
                            return e;
                        }, Collectors.toList()))));
        int a = 3;
    }


    @Data
    static class Student {
        Integer age;
        Integer heitht;
        Integer weight;

        public Student(int age, int heitht, int weight) {
            this.age = age;
            this.heitht = heitht;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", heitht=" + heitht +
                    ", weight=" + weight +
                    '}';
        }
    }

}
