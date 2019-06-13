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
import android.widget.TextView;

public class FragmentDialogScheduleExpanded extends DialogFragment implements FragmentDialogDatePicker.DateDataPass {
    private static final String TAG = "SEA_Log";
    private Button scheduleDate, scheduleTime, scheduleConfirm;
    private String date, time;
    private TextView datetimeselected;


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
        datetimeselected = view.findViewById(R.id.iddatetimeselected);

        try {
            Bundle bundle = this.getArguments();
            if (bundle != null) {
                Log.d(TAG, "onCreateView: Bundle is not null");

                String dateold = bundle.getString("Date");
                Log.d(TAG, "onCreateView: Bundle contents = " + dateold);

                date = bundle.getString("Date");
                time = bundle.getString("Time");
                Log.d(TAG, "onCreateView: Bundle contents | Date + Time = " + date + " " + time);

                datetimeselected.setText("Date: " + date + " Start Time: " + time);
            }
            else
                Log.d(TAG, "onCreateView: Bundle is null");
        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: Exception " + e);
        }

        scheduleDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Schedule Date Clicked");
       /*         getDialog().dismiss();
                FragmentDialogDatePicker fragmentDialogDatePicker = new FragmentDialogDatePicker();
                fragmentDialogDatePicker.show(getFragmentManager(), "Schedule Date");*/
         /*       FragmentDialogShiftType fragmentDialogShiftType = new FragmentDialogShiftType();
                fragmentDialogShiftType.show(getFragmentManager(),"ShiftType");*/
            }
        });
        
        scheduleTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Schedule Time");
                /*
          *//*      FragmentDialogTimePicker fragmentDialogTimePicker = new FragmentDialogTimePicker();
                fragmentDialogTimePicker.show(getFragmentManager(), "Schedule Time")*//*;
                FragmentDialogDatePicker fragmentDialogDatePicker = new FragmentDialogDatePicker();
                fragmentDialogDatePicker.show(getFragmentManager(), "Schedule Date");*/
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
