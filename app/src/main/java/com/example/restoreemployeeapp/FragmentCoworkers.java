package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentCoworkers extends DialogFragment {

    private static final String TAG = "SEA_Log";
    private Button backButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coworkers, container);

        // Getting Items by id
        backButton = view.findViewById(R.id.btn_back);


        // Closing fragment
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
}
