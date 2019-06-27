package com.example.restoreemployeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ScheduleParentActivity extends AppCompatActivity implements FragmentControllerSchedule.BottomSectionControllerListener{
    private static final String TAG = "SEA_Log";
    FragmentDisplaySchedule fragmentDisplaySchedule;
    FragmentControllerSchedule fragmentControllerSchedule;
    String date;
    private TextView selectedDate;
    private Button btnSetSchedule, btnResetUsers;
    private ImageView closeSchedule;
    private UserListAdapter userListAdapter;
    private List<Employee> employeeList;
   // private RecyclerView recyclerView;
/*

    private static final String FragDisplay = "Display";
    private static final String FragSchedule = "Schedule";
*/



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduleparent);

        //Getting passed date
        Intent intent = getIntent();
        date = intent.getStringExtra("Date");


        Log.d(TAG, "onCreate: Date from getIntent = " + date );
        selectedDate = findViewById(R.id.txtSelectedDate);
        selectedDate.setText(date);

        btnResetUsers = findViewById(R.id.btnresetusers);
        closeSchedule = findViewById(R.id.idcloseschedule);
        btnSetSchedule = findViewById(R.id.btnsetschedule);


        // Setting up recyclerview for drag and drop
        RecyclerView recyclerView = findViewById(R.id.recylcerview_scheduleemployees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Adapter 
        // RecyclerViewAdapterUsers recyclerViewAdapterUsers = new RecyclerViewAdapterUsers(view.getContext(), userList, passData);
        /*UserListAdapter*/ userListAdapter = new UserListAdapter();
        SwipeAndDragHelper swipeAndDragHelper = new SwipeAndDragHelper(userListAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeAndDragHelper);
        userListAdapter.setTouchHelper(itemTouchHelper);
        recyclerView.setAdapter(userListAdapter);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        //Creating User Data //TODO transfer all other data like this
        UsersData usersData = new UsersData();
        employeeList = usersData.getEmployeesList();
        userListAdapter.setUserList(employeeList);


        btnResetUsers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Reset Users Clicked");
                //userListAdapter.setUserList(employeeList);
                recreate();
            }
        });

        closeSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Close Schedule Clicked");
                finish();
            }
        });
        
        btnSetSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Set Schedule Clicked");
            }
        });
        
       // fragmentDisplaySchedule = new FragmentDisplaySchedule();
        //fragmentControllerSchedule = new FragmentControllerSchedule();

   /*     FragmentManager fragmentManager = getSupportFragmentManager();

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
        }*/
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
        //fragmentDisplaySchedule.changeLocationTest("OOOO");
    }

    public String getDate() {
        return date;
    }
}
