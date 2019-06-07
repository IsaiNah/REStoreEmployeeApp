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

public class FragmentDialogConfirm extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button yes, no;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdialog_confirm, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            yes = view.findViewById(R.id.idbtconfirmyes);
            no = view.findViewById(R.id.idbtconfirmno);
            
            
            yes.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: Yes clicked");
                }
            });

            no.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: No clicked");
                    getDialog().dismiss();
                }
            });

                return view;
    }
}
