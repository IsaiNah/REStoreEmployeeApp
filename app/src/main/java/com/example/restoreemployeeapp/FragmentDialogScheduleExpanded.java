package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentDialogScheduleExpanded extends DialogFragment implements FragmentDialogDatePicker.DateDataPass {
    private static final String TAG = "SEA_Log";
    private Button scheduleDate, scheduleTime, scheduleConfirm;


    @Override
    public void DateData(String data) {

            Log.d(TAG, "DateData: Working Data Recieved " + data);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragmentdialog_scheduleexpanded, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            
        scheduleDate = view.findViewById(R.id.idbtdate);
        scheduleTime = view.findViewById(R.id.idbttime);
        scheduleConfirm = view.findViewById(R.id.idbtconfirm);
        
        Bundle bundle = this.getArguments();
        if (bundle != null)
        {
            Log.d(TAG, "onCreateView: Bundle is not null");

            String date = bundle.getString("Date");
            Log.d(TAG, "onCreateView: Bundle contents = " + date);

        }


        scheduleDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Schedule Date Clicked");
                getDialog().dismiss();
                FragmentDialogDatePicker fragmentDialogDatePicker = new FragmentDialogDatePicker();
                fragmentDialogDatePicker.show(getFragmentManager(), "Schedule Date");
            }
        });
        
        scheduleTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Schedule Time");
                FragmentDialogTimePicker fragmentDialogTimePicker = new FragmentDialogTimePicker();
                fragmentDialogTimePicker.show(getFragmentManager(), "Schedule Time");
            }
        });
        
        scheduleConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                Log.d(TAG, "onClick: Confirm Clicked");
            }
        });


            
            return view;
    }



}
