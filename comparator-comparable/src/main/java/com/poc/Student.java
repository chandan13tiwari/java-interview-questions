package com.poc;

import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student>{
    String name;
    int age;
    int marks;

    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }

    public static void main(String[] args) {
        Student stu1 = new Student("Chandan", 28, 45);
        Student stu2 = new Student("Ravi", 38, 95);
        Student stu3 = new Student("Kishan", 18, 40);

        List<Student> studentList = new java.util.ArrayList<>(List.of(stu1, stu2, stu3));
        System.out.println("before: " + studentList);
        Collections.sort(studentList);
        System.out.println("after: " + studentList);


    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
