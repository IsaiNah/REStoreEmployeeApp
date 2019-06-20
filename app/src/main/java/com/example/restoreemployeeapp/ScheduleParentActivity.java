package com.example.restoreemployeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ScheduleParentActivity extends AppCompatActivity implements FragmentControllerSchedule.BottomSectionControllerListener{
    private static final String TAG = "SEA_Log";
/*    FragmentDisplaySchedule fragmentDisplaySchedule;
    FragmentControllerSchedule fragmentControllerSchedule;*/


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduleparent);

        Intent intent = getIntent();

        String date = intent.getStringExtra("Date");

       /* fragmentDisplaySchedule = new FragmentDisplaySchedule();
        fragmentControllerSchedule = new FragmentControllerSchedule();*/


        //TODO as in quicki
        try {
            FragmentDisplaySchedule fragmentDisplaySchedule = new FragmentDisplaySchedule();
            fragmentDisplaySchedule.changeLocationTest("WORKING!!!");
        }catch (Exception e)
        {
            Log.d(TAG, "onCreate: Exception " + e);
        }
        Log.d(TAG, "onCreate: Contents of intent extra " + date);

    }

    @Override
    public void testDataPass(String data) {
        Log.d(TAG, "testDataPass: Working " + data);
        //FragmentDisplaySchedule

       // FragmentDisplaySchedule fragmentDisplaySchedule = (FragmentDisplaySchedule) getSupportFragmentManager().findFragmentById(R.id.fragmentDisplay);
        //fragmentDisplaySchedule.changeLocationTest("Bed bugs are a menace");

        FragmentDisplaySchedule fragmentDisplaySchedule = (FragmentDisplaySchedule) getSupportFragmentManager().findFragmentById(R.id.fragdis);
        fragmentDisplaySchedule.changeLocationTest("OOOO");
    }
}
