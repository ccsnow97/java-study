package com.cc.study.jdk.serial;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @Date: 2020/05/22 11:18
 */
public class SerialDemo {

    static void serializePerson() throws IOException {
        Person person = new Person(22,"tom","male");
        File file = new File("e:/person.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
    }

    static Person deSerializePerson() throws IOException, ClassNotFoundException {
        File file = new File("e:/person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Person person = (Person)objectInputStream.readObject();
        return person;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializePerson();
        Person person = deSerializePerson();
        int a=3;
    }

    @Data
    static class Person implements Serializable{
        public static final long serialVersionUID = 3432L;
        private transient int age;
        private String name;
        private String sex;
        private String grade;

        public Person(int age, String name, String sex) {
            this.age = age;
            this.name = name;
            this.sex = sex;
        }
    }

}
