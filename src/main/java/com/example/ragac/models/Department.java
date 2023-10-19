package com.example.ragac.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Department {
    private String name;
    private ArrayList<Employee> members;
}
