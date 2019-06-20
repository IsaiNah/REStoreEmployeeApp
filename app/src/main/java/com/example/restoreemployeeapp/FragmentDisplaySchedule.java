package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentDisplaySchedule extends Fragment {
    private static final String TAG = "SEA_Log";
    private TextView location00, location01, location02; //TODO tmp, change to array

    //TODO Use Class For Scheduling and Contain in Array?

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_displayerschedule, container, false);


        location00 = view.findViewById(R.id.idtxtlocation00);


        location00.setText("TEST");

        changeLocationTest("Method is working");

       // displayTextView = (TextView) view.findViewById(R.id.fragmentDisplayTextView);
     //   displayTextView.setText("Default");

        return view;
    }


    public void changeLocationTest(String string){
        location00.setText(string);
        Log.d(TAG, "changeLocationTest: Method is being called" + string);
    }
}
