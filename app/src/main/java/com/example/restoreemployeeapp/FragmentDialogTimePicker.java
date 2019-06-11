package com.example.restoreemployeeapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import java.util.Calendar;

public class FragmentDialogTimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private static final String TAG = "SEA_Log";
    private String date = "";
    private String time = "";
    private Bundle fullBundle;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        Bundle bundle = this.getArguments();
        if (bundle != null)
        {
            Log.d(TAG, "onCreateView: Bundle is not null");

            date = bundle.getString("Date");
            Log.d(TAG, "onCreateView: Bundle contents = " + date);

        }


       /* fullBundle = new Bundle();
        //getDialog().dismiss();
        try {
            // Extracting date from bundle and adding it to new bundle that will recall scheduleexpanded
            Bundle fullbundle = new Bundle();
            fullbundle.putString("Date", date);
            //fullbundle.putString("Time", time);

            Log.d(TAG, "onCreateDialog: Date + Time " + date + " " + time);

            FragmentDialogScheduleExpanded fragmentDialogScheduleExpanded = new FragmentDialogScheduleExpanded();
            fragmentDialogScheduleExpanded.setArguments(fullbundle);
            fragmentDialogScheduleExpanded.show(getFragmentManager(), "Schedule Expanded");
        }catch (Exception e)
        {
            Log.d(TAG, "onCreateDialog: Exception " + e);
        }*/
        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        Log.d(TAG, "onTimeSet: Time Selected " + hourOfDay + " " + minute);
        time = Integer.toString(hourOfDay) + ":" + Integer.toString(minute);

        fullBundle = new Bundle();
        fullBundle.putString("Date", date);
        fullBundle.putString("Time" , time);

        Log.d(TAG, "onCreateDialog: Date + Time " + date + " " + time);

        //Reopening Fragment with bundle
        FragmentDialogScheduleExpanded fragmentDialogScheduleExpanded = new FragmentDialogScheduleExpanded();
        fragmentDialogScheduleExpanded.setArguments(fullBundle);
        fragmentDialogScheduleExpanded.show(getFragmentManager(), "Schedule Expanded");



        /*getDialog().dismiss();*/
    }


}

