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

public class FragmentDialogNavStoresExpanded extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button store00, store01, store02;
    //private Intent // TODO add intents
    private PassData passData; // Interface to passdata from expanded dialog to map fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdialog_navexpanded, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);


        // TODO change to recyclerView w/arrayList when more data
        
        store00 = view.findViewById(R.id.idbtstore00);
        store01 = view.findViewById(R.id.idbtstore01);
        store02 = view.findViewById(R.id.idbtstore02);
        
        
        store00.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: store00 clicked");
                //passData.passdata(" TEST Pass working");
            }
        });

        store01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: store01 clicked");
            }
        });
        store02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: store02 clicked");
            }
        });
        

        return view;
    }
}
