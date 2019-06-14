package com.example.restoreemployeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ScheduleParentActivity extends AppCompatActivity implements FragmentControllerSchedule.BottomSectionControllerListener{
    private static final String TAG = "SEA_Log";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduleparent);

        //TODO as in quicki
        FragmentDisplaySchedule fragmentDisplaySchedule = new FragmentDisplaySchedule();


        Intent intent = getIntent();

        String date = intent.getStringExtra("Date");

        Log.d(TAG, "onCreate: Contents of intent extra " + date);

    }

    @Override
    public void testDataPass(String data) {
        Log.d(TAG, "testDataPass: Working " + data);
        //FragmentDisplaySchedule

    }
}
