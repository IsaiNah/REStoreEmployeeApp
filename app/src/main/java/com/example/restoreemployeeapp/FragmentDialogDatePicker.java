package com.example.restoreemployeeapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class FragmentDialogDatePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private static final String TAG = "SEA_Log";
    private DateDataPass dateDataPass;

    //TODO INTERFACE TO PASS DATE DATA
    // Trial interface
    public interface DateDataPass
    {
        void DateData(String data);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        /*final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));*/

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), dateSetListener, year, month, day);
    }
    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    Toast.makeText(getActivity(), "selected date is " + view.getYear() +
                            " / " + (view.getMonth()) +
                            " / " + view.getDayOfMonth(), Toast.LENGTH_SHORT).show();

                    Log.d(TAG, "onDateSet: Date Selected " + year + "/" + month + "/" + day);
                   //Recording Date to String
                   String date = Integer.toString(year) + "/" + Integer.toString(month) + "/" + Integer.toString(day);
                    Log.d(TAG, "onDateSet: Int to String : " + date);

                    try {
                        DateDataPass dateDataPass = (DateDataPass) getActivity();
                        dateDataPass.DateData("Test");
                    }catch (Exception e)
                    {
                        Log.d(TAG, "onDateSet: Exception " + e);
                    }

                    Bundle bundle = new Bundle();
                    bundle.putString("Date", date);
                    FragmentDialogScheduleExpanded fragmentDialogScheduleExpanded = new FragmentDialogScheduleExpanded();
                    fragmentDialogScheduleExpanded.setArguments(bundle);
                   fragmentDialogScheduleExpanded.show(getFragmentManager(), "Schedule Expanded");
                    getDialog().dismiss();

                }
            };
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        Log.d(TAG, "onTimeSet: Time picked = " + hourOfDay +  " Minutes " + minute);

    }


}
