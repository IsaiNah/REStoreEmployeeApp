package com.example.restoreemployeeapp;

import android.util.Log;

public class Store {

    private static final String TAG = "SEA_Log";

    private int id;
    private String name, address, postal, phone;

    public Store(String name, String address, String postal, String phone)
    {
        this.name = name;
        this.address = address;
        this.postal = postal;
        this.phone = phone;

        Log.d(TAG, "Location in store | New store created : " + name + " " +  address + " " + postal + " " + phone );
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPostal() {
        return postal;
    }

    public String getPhone() {
        return phone;
    }
}
