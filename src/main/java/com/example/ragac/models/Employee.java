package com.example.ragac.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private String name;
    private String lastName;
    private int age;
    private int salary;

    @Override
    public String toString() {
        return name + " " + lastName + " age:" + age + " salary:" + salary;
    }
}
