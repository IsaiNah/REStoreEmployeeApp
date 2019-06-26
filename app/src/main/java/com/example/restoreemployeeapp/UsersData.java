package com.example.restoreemployeeapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Srijith on 08-10-2017.
 */

public class UsersData {

    private List<Employee> usersList = new ArrayList<Employee>() {
        {
            add(new Employee(0, "", "", "Developers"));
            add(new Employee(1, "Frederick Hoffman", "https://randomEmployee.me/api/portraits/men/52.jpg", "Developers"));
            add(new Employee(2, "Calvin Young", "https://randomEmployee.me/api/portraits/men/78.jpg", "Developers"));
            add(new Employee(3, "Jeanette Reid", "https://randomEmployee.me/api/portraits/women/37.jpg", "Developers"));
            add(new Employee(4, "Flenn Wilson", "https://randomEmployee.me/api/portraits/men/40.jpg", "Developers"));
            add(new Employee(5, "Martin Holland", "https://randomEmployee.me/api/portraits/men/0.jpg", "Developers"));
            add(new Employee(6, "", "", "Designers"));
            add(new Employee(7, "Jeanette Simmmons", "https://randomEmployee.me/api/portraits/women/3.jpg", "Designers"));
            add(new Employee(8, "Wallace Lambert", "https://randomEmployee.me/api/portraits/men/53.jpg", "Designers"));
            add(new Employee(9, "Andy Clark", "https://randomEmployee.me/api/portraits/men/68.jpg", "Designers"));
            add(new Employee(10, "olivia obrien", "https://randomEmployee.me/api/portraits/women/93.jpg", "Designers"));
            add(new Employee(11, "Debbie Bennett", "https://randomEmployee.me/api/portraits/women/34.jpg", "Designers"));
            add(new Employee(12, "", "", "Team Leads"));
            add(new Employee(13, "Bernice Lawson", "https://randomEmployee.me/api/portraits/women/20.jpg", "Team Leads"));
            add(new Employee(14, "Camila Elliott", "https://randomEmployee.me/api/portraits/women/60.jpg", "Team Leads"));
            add(new Employee(15, "Gerald Webb", "https://randomEmployee.me/api/portraits/men/55.jpg", "Team Leads"));
            add(new Employee(16, "Russell Hart", "https://randomEmployee.me/api/portraits/men/18.jpg", "Team Leads"));
            add(new Employee(17, "Joyce Mccoy", "https://randomEmployee.me/api/portraits/women/82.jpg", "Team Leads"));
            add(new Employee(18, "", "", "Team Managers"));
            add(new Employee(19, "Daryl Banks", "https://randomEmployee.me/api/portraits/men/4.jpg", "Team Managers"));
            add(new Employee(20, "Veronica Vargas", "https://randomEmployee.me/api/portraits/women/14.jpg", "Team Managers"));
            add(new Employee(21, "Natalie Jacobs", "https://randomEmployee.me/api/portraits/women/0.jpg", "Team Managers"));
            add(new Employee(22, "Beverly Kennedy", "https://randomEmployee.me/api/portraits/women/30.jpg", "Team Managers"));
        }
    };

    public List<Employee> getEmployeesList() {
        return usersList;
    }
}
