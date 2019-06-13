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

public class FragmentDialogSelectStoreExpanded extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button store00, store01, store02;
    //private Intent // TODO add intents
    private PassData passData; // Interface to passdata from expanded dialog to map fragment
    private NavToStoreListener navToStoreListener;

    //TODO remove unused interface
    // Test interface DialogFragment to Activity
    public interface NavToStoreListener {
         void navToStore(String storename);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdialog_selectstore, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);


        // TODO change to recyclerView w/arrayList when more data
        // TODO pass data to activity w/interface
        
        store00 = view.findViewById(R.id.idbtselectstore00);
        store01 = view.findViewById(R.id.idbtselectstore01);
        store02 = view.findViewById(R.id.idbtselectstore02);

      /*  try{
            navToStoreListener = (NavToStoreListener) getTargetFragment();
        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: Exception " + e);
        }*/


        store00.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: store00 clicked");
                getDialog().dismiss();
                Bundle bundle = new Bundle();
                bundle.putString("Location", "Barrie");
                FragmentDialogShiftType FragmentDialogShiftType = new FragmentDialogShiftType();
                FragmentDialogShiftType.setArguments(bundle);
                FragmentDialogShiftType.show(getFragmentManager(),"SellerType");
            }
        });

        store01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: store01 clicked");
                getDialog().dismiss();
                Bundle bundle = new Bundle();
                bundle.putString("Location", "Scarborough");
                FragmentDialogShiftType fragmentDialogShiftType = new FragmentDialogShiftType();
                fragmentDialogShiftType.setArguments(bundle);
                fragmentDialogShiftType.show(getFragmentManager(),"SellerType");
         

            }
        });
        store02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: store02 clicked");
                getDialog().dismiss();
                Bundle bundle = new Bundle();
                bundle.putString("Location", "Brampton");
                FragmentDialogShiftType FragmentDialogShiftType = new FragmentDialogShiftType();
                FragmentDialogShiftType.setArguments(bundle);
                FragmentDialogShiftType.show(getFragmentManager(),"SellerType");
       
            }
        });
        

        return view;
    }
}
