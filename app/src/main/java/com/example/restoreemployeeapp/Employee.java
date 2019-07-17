package com.example.restoreemployeeapp;


public class Employee {

    private int id;
    private String name;
    private String imageUrl;
    private String type;
    private String rank;

    public Employee(int id, String name, String imageUrl, String type, String rank) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.type = type;
        this.rank = rank;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.imageUrl = employee.imageUrl;
        this.type = employee.type;
        this.rank = employee.rank;
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

    public String getRank(){
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
