package com.karolina.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Paweł on 2019-01-27.
 */
public class StreamSimpleExample {
    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates1", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0),
            new Employee(4, "Mark fff", 500000.0)
    };
    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
    public static void main(String[] args){
/*

        System.out.println(Stream.of(arrayOfEmps));

        empList.stream().forEach(employee -> employee.salaryIncrement(10.0));
       Employee emp = empList.get(0);
        System.out.println( emp.getName() +", " +emp.getSalary());

        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };*/

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());

        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());



    }
}

class Employee {
    public int getNumber() {
        return number;
    }

    int number;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    String name;
    double salary;

    Employee(int number, String name, double salary) {
        this.name = name;
        this.number = number;
        this.salary = salary;

    }


    public void salaryIncrement(double v) {
        this.salary += v;
    }

    public  String toString() {
        return this.name+", "+ this.number +", "+ this.salary;
    }
}
