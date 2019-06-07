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

public class FragmentDialogManageExpanded extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button scheduleButton, editButton, removeButton;
    //private Intent // TODO add intents


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdialog_manageexpanded, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        scheduleButton = view.findViewById(R.id.idbtscheduleemployee);
        editButton = view.findViewById(R.id.idbteditemployee);
        removeButton = view.findViewById(R.id.idbtremoveemployee);

        scheduleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Schedule Button");
                try{
                FragmentDialogNavStoresExpanded fragmentDialogNavStoresExpanded = new FragmentDialogNavStoresExpanded();
                fragmentDialogNavStoresExpanded.show(getFragmentManager(), "text");
                }
                catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }
            }
        });

        editButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Edit Button");
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Remove Button");
                FragmentDialogConfirm fragmentDialogConfirm = new FragmentDialogConfirm();
                fragmentDialogConfirm.show(getFragmentManager(), "text");
            }
        });
        return view;
    }
}
