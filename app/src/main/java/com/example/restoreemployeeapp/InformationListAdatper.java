package com.example.restoreemployeeapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class InformationListAdatper extends ArrayAdapter<Information> {

    private static final String TAG = "SEA_Log";
    private Context context;

    public InformationListAdatper(Context context, int resource, ArrayList<Information> objects) {
        super(context, resource, objects);
        this.context = context;
    }
}
