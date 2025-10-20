package com.poc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee1 {
    String name;
    int age;

    public Employee1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Employee {
    public static void main(String[] args) {
        Employee1 emp1 = new Employee1("Chadnan", 34);
        Employee1 emp2 = new Employee1("Ravi", 45);
        Employee1 emp3 = new Employee1("Kishan", 18);

        List<Employee1> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        System.out.println("before: " + employeeList);
        Comparator<Employee1> comparator1 = (o1, o2) -> {
            return o1.name.compareTo(o2.name);
        };
        Collections.sort(employeeList, comparator1);
        System.out.println("after: " + employeeList);
    }
}
