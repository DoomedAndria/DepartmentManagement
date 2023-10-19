package com.example.ragac;

import com.example.ragac.models.Department;
import com.example.ragac.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    public static List<Department> departments = new ArrayList<>(Arrays.asList(
            new Department("IT Department", new ArrayList<>(Arrays.asList(
                    new Employee("Olivia", "Martinez", 25, 42000),
                    new Employee("James", "Anderson", 33, 58000),
                    new Employee("Sophia", "Garcia", 29, 49000)
            ))),
            new Department("HR Department", new ArrayList<>(Arrays.asList(
                    new Employee("William", "Johnson", 40, 68000),
                    new Employee("Emma", "Taylor", 26, 45000)
            )))
    ));
}
