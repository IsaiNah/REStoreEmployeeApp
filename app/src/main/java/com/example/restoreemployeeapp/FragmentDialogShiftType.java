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

public class FragmentDialogShiftType extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button firstShift, secondShift;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdialog_shifttype, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);




        firstShift = view.findViewById(R.id.idbtfirstshift);
        secondShift = view.findViewById(R.id.idbtsecondshift);


        firstShift.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: First shift clicked");
                getDialog().dismiss();
                Bundle bundle = new Bundle();
                bundle.putString("Type", "First");
                FragmentDialogSellerType fragmentDialogSellerType = new FragmentDialogSellerType();
                fragmentDialogSellerType.setArguments(bundle);
                fragmentDialogSellerType.show(getFragmentManager(),"SellerType");
            }
        });

        secondShift.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Second shift clicked");
                getDialog().dismiss();
                Bundle bundle = new Bundle();
                bundle.putString("Type", "Second");
                FragmentDialogSellerType fragmentDialogSellerType = new FragmentDialogSellerType();
                fragmentDialogSellerType.setArguments(bundle);
                fragmentDialogSellerType.show(getFragmentManager(),"SellerType");
            }
        });

        

        return view;
    }
}
