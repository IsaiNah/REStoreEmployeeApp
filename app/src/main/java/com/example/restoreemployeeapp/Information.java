package com.example.restoreemployeeapp;

public class Information {
    private String title, subTitleA, subTitleB;
    private int id;

    public Information(int id, String title, String subTitleA, String subTitleB) {
        this.id = id;
        this.title = title;
        this.subTitleA = subTitleA;
        this.subTitleB = subTitleB;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitleA() {
        return subTitleA;
    }

    public void setSubTitleA(String subTitleA) {
        this.subTitleA = subTitleA;
    }

    public String getSubTitleB() {
        return subTitleB;
    }

    public void setSubTitleB(String subTitleB) {
        this.subTitleB = subTitleB;
    }
}
