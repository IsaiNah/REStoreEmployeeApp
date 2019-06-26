package com.example.restoreemployeeapp;

/**
 * Created by Srijith on 08-10-2017.
 */

public class Employee {

    private int id;
    private String name;
    private String imageUrl;
    private String type;

    public Employee(int id, String name, String imageUrl, String type) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.type = type;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.imageUrl = employee.imageUrl;
        this.type = employee.type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getType() {
        return type;
    }
}
