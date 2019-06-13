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
    private PassData passData;

    public interface SellerTypeListener{
        void sellerType(String type);
    }

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
        final String sellerType = bundle.getString("Type");
        Log.d(TAG, "onCreateView: Bundle Contents Seller Type = " + sellerType);


       //TODO open List of various types of sellers with selector highlighting when clicked
        firstSeller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: First clicked");
                //passing data by interface to MainMenu Activity
                SellerTypeListener sellerTypeListener = (SellerTypeListener) getActivity();
                sellerTypeListener.sellerType("Gold");
                getDialog().dismiss();

            }
        });

        secondSeller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Second clicked");
                //passing data by interface to MainMenu Activity
                SellerTypeListener sellerTypeListener = (SellerTypeListener) getActivity();
                sellerTypeListener.sellerType("Silver");
                getDialog().dismiss();
            }
        });

        thirdSeller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Third clicked");
                //passing data by interface to MainMenu Activity
                SellerTypeListener sellerTypeListener = (SellerTypeListener) getActivity();
                sellerTypeListener.sellerType("Bronze");
                getDialog().dismiss();
            }
        });

        return view;
    }
}
