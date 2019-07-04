package com.example.restoreemployeeapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Srijith on 08-10-2017.
 */

public class UsersData {

    private static final String TAG = "SEA_Log";

    private List<Employee> usersList = new ArrayList<Employee>() {
        {
            add(new Employee(0, "", "", "OroGold Barrie", ""));
            add(new Employee(1, "", "", "OroGold Scarborough", ""));
            add(new Employee(2, "", "", "OroGold Brampton", ""));
            add(new Employee(3, "", "", "Not Set", ""));
            add(new Employee(4, "Frederick Hoffman", "https://randomUser.me/api/portraits/men/52.jpg", "Not Set","Gold"));
            add(new Employee(5, "Calvin Young", "https://randomUser.me/api/portraits/men/78.jpg", "Not Set","Gold"));
            add(new Employee(6, "Jeanette Reid", "https://randomUser.me/api/portraits/women/37.jpg", "Not Set","Gold"));
            add(new Employee(7, "Flenn Wilson", "https://randomUser.me/api/portraits/men/40.jpg", "Not Set","Gold"));
            add(new Employee(8, "Martin Holland", "https://randomUser.me/api/portraits/men/0.jpg", "Not Set","Gold"));
            add(new Employee(9, "Jeanette Simmmons", "https://randomUser.me/api/portraits/women/3.jpg", "Not Set","Silver"));
            add(new Employee(10, "Wallace Lambert", "https://randomUser.me/api/portraits/men/53.jpg", "Not Set", "Silver"));
            add(new Employee(11, "Andy Clark", "https://randomUser.me/api/portraits/men/68.jpg", "Not Set", "Silver"));
            add(new Employee(12, "olivia obrien", "https://randomUser.me/api/portraits/women/93.jpg", "Not Set", "Silver"));
            add(new Employee(13, "Debbie Bennett", "https://randomUser.me/api/portraits/women/34.jpg", "Not Set", "Silver"));
            add(new Employee(14, "Bernice Lawson", "https://randomUser.me/api/portraits/women/20.jpg", "Not Set", "Silver"));
            add(new Employee(15, "Camila Elliott", "https://randomUser.me/api/portraits/women/60.jpg", "Not Set", "Silver"));
            add(new Employee(16, "Gerald Webb", "https://randomUser.me/api/portraits/men/55.jpg", "Not Set", "Bronze"));
            add(new Employee(17, "Russell Hart", "https://randomUser.me/api/portraits/men/18.jpg", "Not Set", "Bronze"));
            add(new Employee(18, "Joyce Mccoy", "https://randomUser.me/api/portraits/women/82.jpg", "Not Set", "Bronze"));
            add(new Employee(19, "Daryl Banks", "https://randomUser.me/api/portraits/men/4.jpg", "Not Sets", "Bronze"));
            add(new Employee(20, "Veronica Vargas", "https://randomUser.me/api/portraits/women/14.jpg", "Not Set", "Bronze"));
            add(new Employee(21, "Natalie Jacobs", "https://randomUser.me/api/portraits/women/0.jpg", "Not Set", "Bronze"));
            add(new Employee(22, "Beverly Kennedy", "https://randomUser.me/api/portraits/women/30.jpg", "Not Set", "Bronze"));
        }
    };

    public List<Employee> getEmployeesList() {
        return usersList;
    }

    public List<Employee> sortUsers(String type) {

        List<Employee> newList = new ArrayList<Employee>(){};
        for (int i =0; i < usersList.size(); i++) {

            //TODO create var for set and not set and only filter not set
           // Log.d(TAG, "sortUsers: " + i + type);
            String name = usersList.get(i).getName();
            Log.d(TAG, "sortUsers: " + name + " " + i);
            if (!usersList.get(i).getRank().equals(type)/* && !usersList.get(i).getName().equals("")*/)
            {
                Log.d(TAG, "sortUsers: Not right type");
               // usersList.remove(i); //TODO use 2 lists?

            }else
            {
                Log.d(TAG, "sortUsers: Right type");
                newList.add(usersList.get(i));
                //usersList.get(i)
            }
        }

        return newList;
    }
}
