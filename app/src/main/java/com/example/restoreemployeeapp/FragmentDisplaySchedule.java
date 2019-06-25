package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FragmentDisplaySchedule extends Fragment {
    private static final String TAG = "SEA_Log";
    private TextView dateSelected ,location00, location01, location02; //TODO tmp, change to array
    private RecyclerView recyclerView;

    private List<User> userList;

    //TODO Use Class For Scheduling and Contain in Array?

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_displayerschedule, container, false);

        String acquireDate = ((ScheduleParentActivity)getActivity()).getDate();

        dateSelected = view.findViewById(R.id.dateSelected);
        location00 = view.findViewById(R.id.idtxtlocation00);

        dateSelected.setText(acquireDate);
        location00.setText("TEST");

        //SETTING UP DUMMY DATA FOR DRAG AND DROP
        userList = new ArrayList<>();

        userList.add(new User(
                "employee00@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userList.add(new User(
                "employee01@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userList.add(new User(
                "employee02@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userList.add(new User(
                "employee03@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));


        ///////END OF DUMMY DATA FOR DRAG AND DROP


        // Setting up recyclerview for drag and drop
        recyclerView = view.findViewById(R.id.recylcerview_scheduleemployees);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        //Adapter TODO FINISH HERE https://therubberduckdev.wordpress.com/2017/10/24/android-recyclerview-drag-and-drop-and-swipe-to-dismiss/
       // RecyclerViewAdapterUsers recyclerViewAdapterUsers = new RecyclerViewAdapterUsers(view.getContext(), userList, );



        Log.d(TAG, "onCreateView: Date acquired : " + acquireDate);

        changeLocationTest("Method is working");

       // displayTextView = (TextView) view.findViewById(R.id.fragmentDisplayTextView);
     //   displayTextView.setText("Default");

        return view;
    }


    public void changeLocationTest(String string){
        location00.setText(string);
        Log.d(TAG, "changeLocationTest: Method is being called" + string);
    }

    //TODO unused interface
    PassData passData = new PassData() {
        @Override
        public void passdata(String string) {
            Log.d(TAG, "passdata: WORKING! " + string);
            //TODO unused interface set in order to call AdapterUsers for  Testing
        }
    };
}
