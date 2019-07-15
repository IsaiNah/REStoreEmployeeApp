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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ScheduleParentActivity extends AppCompatActivity implements /*UserListAdapter.PassFromAdapter,*/ AdapterView.OnItemSelectedListener ,FragmentControllerSchedule.BottomSectionControllerListener{
    private static final String TAG = "SEA_Log";
    FragmentDisplaySchedule fragmentDisplaySchedule;
    FragmentControllerSchedule fragmentControllerSchedule;
    String date;
    private TextView selectedDate;
    private Button btnSetSchedule, btnResetUsers;
    private ImageView closeSchedule;
    private UserListAdapter userListAdapter;
    private List<Employee> employeeList, employeeListGold, employeeListSilver, employeeListBronze; // Full list + sorted lists
    private Spinner filterSpinner;
    //Data for spinner
    private String[] filterData = {"All", "Gold", "Silver", "Bronze"};
    private UsersData usersData;
    //private UserListAdapter.PassFromAdapter
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

       /* registerForContextMenu();*/


        Log.d(TAG, "onCreate: Date from getIntent = " + date );
        selectedDate = findViewById(R.id.txtSelectedDate);
        selectedDate.setText(date);

        btnResetUsers = findViewById(R.id.btnresetusers);
        closeSchedule = findViewById(R.id.idcloseschedule);
        btnSetSchedule = findViewById(R.id.btnsetschedule);

        //Setting Spinner
        filterSpinner = findViewById(R.id.btnspinnerfilter);
        filterSpinner.setOnItemSelectedListener(this);
        //Creating Array Adapter for spinner
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,filterData);
        //Style for spinner
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting Spinner adapter
        filterSpinner.setAdapter(arrayAdapter);

        // Setting up recyclerview for drag and drop
        RecyclerView recyclerView = findViewById(R.id.recylcerview_scheduleemployees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Adapter 
        // RecyclerViewAdapterUsers recyclerViewAdapterUsers = new RecyclerViewAdapterUsers(view.getContext(), userList, passData);
        /*UserListAdapter*/ userListAdapter = new UserListAdapter(passData);
        SwipeAndDragHelper swipeAndDragHelper = new SwipeAndDragHelper(userListAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeAndDragHelper);
        userListAdapter.setTouchHelper(itemTouchHelper);
        recyclerView.setAdapter(userListAdapter);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        //Creating User Data //TODO transfer all other data like this
         usersData = new UsersData();
        employeeList = usersData.getEmployeesList();

        userListAdapter.setUserList(employeeList);

        //Presorting users
        employeeListGold = usersData.sortUsers("Gold");
        employeeListSilver = usersData.sortUsers("Silver");
        employeeListBronze = usersData.sortUsers("Bronze");

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
                userListAdapter.setUserList(employeeList);
                Log.d(TAG, "onClick: "  + employeeList.get(4).getName() + " " + employeeList.get(4).getType());
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

    // Filter
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemSelected: Selected, Position = " + position + " id = " + id);
        Toast.makeText(getApplicationContext(), filterData[position],Toast.LENGTH_LONG).show();
        switch (position) {
        case 0:
            userListAdapter.setUserList(employeeList);
            //userListAdapter.notifyDataSetChanged();
           //
        break;
            case 1:
                employeeListGold = usersData.sortUsers("Gold");
                userListAdapter.setUserList(employeeListGold);
             //   employeeListGold = usersData.sortUsers("Silver");
                break;
            case 2:
                employeeListGold = usersData.sortUsers("Silver");
               userListAdapter.setUserList(employeeListSilver);

                break;
            case 3:
                employeeListGold = usersData.sortUsers("Bronze");
                userListAdapter.setUserList(employeeListBronze);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

    /*UserListAdapter.PassFromAdapter passFromAdapter = new UserListAdapter.PassFromAdapter() {
        @Override
        public void adapterPass(String data) {
            Log.d(TAG, "adapterPass: Data Recieved From Adapter : " + data);
        }
    };
*/

   /* @Override
    public void adapterPass(String data) {
        Log.d(TAG, "adapterPass: " + data);
    }*/

   PassData passData = new PassData() {
       @Override
       public void passdata(String string) {
           Log.d(TAG, "passdata: interface working = " + string);
           //TODO add employee to new pos then delete old version

           //Employee setEmployee = new Employee(4, "Changed!", "https://randomUser.me/api/portraits/men/52.jpg", "OroGold Barrie", "Gold");
           //usersData.getEmployeesList().set(5, setEmployee);
           //employeeList.add(setEmployee);
           //userListAdapter.setUserList(employeeList);
            //usersData.getEmployeesList().get(6).set;
            //TODO return pos of title in order to always know underwhich pos to add user
            //TODO use onViewMoved?
           //TODO iterate though list (in UserData), find type -> get pos according to type
           //usersData.getEmployeesList().

           //userListAdapter.getItemViewType()
           //int pos = usersData.findPos("OroGold Brampton");
           //Log.d(TAG, "passdata: PoS = " + pos);

           //Getting the last pos of string in order to pass current position
           int oldpos = Integer.parseInt(string.substring(string.length() -1));

           Log.d(TAG, "passdata: oldpos = " +oldpos);
            userListAdapter.setUserList(employeeList);
           userListAdapter.setPos("OroGold Barrie", oldpos);

           //userListAdapter.

          // userListAdapter.onViewMoved(4, 2);
          // userListAdapter.onViewMoved(5, 2);
         //  userListAdapter.onViewMoved(6, 2);
       }
   };
}
