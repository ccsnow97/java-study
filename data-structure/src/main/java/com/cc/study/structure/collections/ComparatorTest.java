package com.cc.study.structure.collections;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2020/05/25 14:16
 */
public class ComparatorTest {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(12,133,45));
        list.add(new Student(12,133,46));
        list.add(new Student(12,131,43));
        list.add(new Student(10,133,45));

        list.sort(Comparator.comparing(Student::getAge,
                Integer::compareTo).thenComparing(Student::getHeitht,Integer::compareTo)
        .thenComparing(Student::getWeight,Integer::compareTo)
        );

        list.forEach(System.out::println);

        int a=3;
    }

    @Data
    static class Student{
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
