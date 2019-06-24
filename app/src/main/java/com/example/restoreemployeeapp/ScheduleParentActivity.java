package com.example.restoreemployeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ScheduleParentActivity extends AppCompatActivity implements FragmentControllerSchedule.BottomSectionControllerListener{
    private static final String TAG = "SEA_Log";
    FragmentDisplaySchedule fragmentDisplaySchedule;
    FragmentControllerSchedule fragmentControllerSchedule;
    String date;
/*

    private static final String FragDisplay = "Display";
    private static final String FragSchedule = "Schedule";
*/



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduleparent);

        Intent intent = getIntent();

        date = intent.getStringExtra("Date");

        Log.d(TAG, "onCreate: Date from getIntent = " + date );

       // fragmentDisplaySchedule = new FragmentDisplaySchedule();
        //fragmentControllerSchedule = new FragmentControllerSchedule();

        FragmentManager fragmentManager = getSupportFragmentManager();

        try {
            fragmentDisplaySchedule = (FragmentDisplaySchedule) fragmentManager.findFragmentById(R.id.fragdis);
            if (fragmentDisplaySchedule == null) {
                Log.d(TAG, "onCreate: Fragment Schedule was null");
            }
        }catch (Exception e)
        {
            Log.d(TAG, "onCreate: Exception " + e);
        }
        try {
            fragmentDisplaySchedule = (FragmentDisplaySchedule) fragmentManager.findFragmentById(R.id.fragdis);
            if (fragmentDisplaySchedule == null) {
                Log.d(TAG, "onCreate: Fragment Schedule was null");
            }
        }catch (Exception e)
        {
            Log.d(TAG, "onCreate: Exception " + e);
        }
        //fragmentDisplaySchedule = fragmentManager.findFragmentByTag(FragDisplay);

        /*//TODO as in quicki
        try {
            FragmentDisplaySchedule fragmentDisplaySchedule = new FragmentDisplaySchedule();
            fragmentDisplaySchedule.changeLocationTest("WORKING!!!");
        }catch (Exception e)
        {
            Log.d(TAG, "onCreate: Exception " + e);
        }
        Log.d(TAG, "onCreate: Contents of intent extra " + date);*/

    }

    @Override
    public void testDataPass(String data) {
        Log.d(TAG, "testDataPass: Working " + data);
        //FragmentDisplaySchedule

        //FragmentDisplaySchedule fragmentDisplaySchedule = (FragmentDisplaySchedule) getSupportFragmentManager().findFragmentById(R.id.fragmentDisplay);
       // FragmentDisplaySchedule fragmentDisplaySchedule = (FragmentDisplaySchedule) getSupportFragmentManager().findFragmentById(R.id.fragdis);
       // fragmentDisplaySchedule.changeLocationTest("Bed bugs are a menace");

        //FragmentDisplaySchedule fragmentDisplaySchedule = getSupportFragmentManager().findFragmentById(R.id.fragdis);
        fragmentDisplaySchedule.changeLocationTest("OOOO");
    }

    public String getDate() {
        return date;
    }
}
