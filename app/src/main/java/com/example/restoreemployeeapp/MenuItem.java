package com.example.restoreemployeeapp;

import android.support.v7.app.AppCompatActivity;

public class MenuItem extends AppCompatActivity {
    private static final String TAG = "SEA_Log";

private int id;
private String menuTitle;
private int image;

public MenuItem (int id, String menuTitle, int image)
{
    this.id = id;
    this.menuTitle = menuTitle;
    this.image = image;

}

    public int getId() {
        return id;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public int getImage() {
        return image;
    }
}
