package com.example.restoreemployeeapp;

import android.util.Log;

public class User {

    private static final String TAG = "SEA_Log";

    private int _id;
    private String  email, firstName, lastName, password, addressone, postal, phone = "Not Set";
    //Seperating reg and log varaibles tmp?
    static String logEmail, logPassword = "Not set";

public  User(String email, String firstName, String lastName, String password, String addressone, String postal, String phone)
{
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.addressone = addressone;
    this.postal = postal;
    this.phone = phone;
    Log.d(TAG, "Location in user | New user created :" + email + " " +  password + " " + phone );
}

    public User(String username, String password)
    {
        this.logEmail = username;
        this.logPassword = password;
        //TODO Load all data from database in this case
        Log.d(TAG, "Location in user | New user created :" + email + " " +  password + " " );
    }


    //Getters


    public int get_id() {
        return _id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddressone() {
        return addressone;
    }

    public String getPostal() {
        return postal;
    }

    public String getPhone() {
        return phone;
    }

    public static String getLogEmail() {
        return logEmail;
    }

    public static String getLogPassword() {
        return logPassword;
    }
}
