package com.cc.study.structure.collections;

import lombok.Data;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Date: 2020/05/26 15:04
 */
public class MapTest {

    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>(4);
        map.put(new Student(11), "tom");
        map.put(new Student(21), "tony");
        map.put(new Student(32), "lily");
        map.put(new Student(42), "saky");
        String s = map.get(new Student(42));
        String remove = map.remove(new Student(42));

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalMemory = Runtime.getRuntime().totalMemory()/(1024*1024);
        long maxMemory = Runtime.getRuntime().maxMemory()/(1024*1024);
        long freeMemory = Runtime.getRuntime().freeMemory()/(1024*1024);

        int a=-16;
        String s3 = Integer.toBinaryString(16);
        String s2 = Integer.toBinaryString(a);
        int b = -16>>2;
        String s1 = Integer.toBinaryString(b);
        int z = 3;
    }



    static void testEntry() {
        Comparator<Map.Entry<String, Integer>> entryComparator = Map.Entry.comparingByKey();

    }


    @Data
    static class Student {
        Integer age;
        Integer heitht;
        Integer weight;

        public Student(Integer age) {
            this.age = age;
        }

        public Student(int age, int heitht, int weight) {
            this.age = age;
            this.heitht = heitht;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(age, student.age);
        }

        @Override
        public int hashCode() {

            return age % 10;
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
