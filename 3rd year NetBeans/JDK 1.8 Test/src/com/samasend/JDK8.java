package com.samasend;

import java.util.ArrayList;
import java.util.List;

public class JDK8 {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        list.add(new Person("Samson", 20));
        list.add(new Person("Samuel", 21));
        list.add(new Person("Mohammed", 23));
        list.add(new Person("Abel", 25));
        list.add(new Person("Yaya", 23));
        list.add(new Person("Jimmy", 19));

        System.out.println("Sorted by Name: ");
        list.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        list.forEach(System.out::println);

        System.out.println("Sorted by Age: ");
        list.sort((Person p1, Person p2) -> (Integer.compare(p1.getAge(), p2.getAge())));
        list.forEach(System.out::println);
    }

    private static class Person {

        private String name;
        private int age;

        @Override
        public String toString() {
            return String.format("%8s %d", getName(), getAge());
        }

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
