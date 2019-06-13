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

public class FragmentDialogSellerType extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button firstSeller, secondSeller, thirdSeller;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdialog_sellertype, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);


        firstSeller = view.findViewById(R.id.idbtfirstseller);
        secondSeller = view.findViewById(R.id.idbtsecondseller);
        thirdSeller = view.findViewById(R.id.idbtthirdseller);


        Bundle bundle = getArguments();
        String sellerType = bundle.getString("Type");
        Log.d(TAG, "onCreateView: Bundle Contents Seller Type = " + sellerType);


        firstSeller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: First clicked");
            }
        });

        secondSeller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Second clicked");
            }
        });

        thirdSeller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Second clicked");
            }
        });

        return view;
    }
}
