package com.libjavapractice.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueWithArray {

    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.age - s2.age;
        }
    }

    static class NameComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.offer(1);

        Queue<Integer> q2 = new LinkedList<>();
        q2.offer(2);
        q2.add(3);

        q1.addAll(q2);
        q1.remove(2);

        System.out.println(q1);


//        Queue<Student> q3 = new PriorityQueue<>(new AgeComparator());
        Queue<Student> q3 = new PriorityQueue<>(new NameComparator());
        q3.add(new Student("V", 26));
        q3.add(new Student("A", 2));
        q3.add(new Student("B", 5));

        //q3.forEach(element -> System.out.println("q3:\t" + element.toString()));

        System.out.println("************\n");
        while (!q3.isEmpty()) {
            System.out.print(q3.poll().name + " ");
        }
        System.out.println("\n************");
    }
}
