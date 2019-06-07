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
    private NavToStoreListener navToStoreListener;

    //TODO remove unused interface
    // Test interface DialogFragment to Activity
    public interface NavToStoreListener {
         void navToStore(String storename);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentdialog_navexpanded, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);


        // TODO change to recyclerView w/arrayList when more data
        // TODO pass data to activity w/interface
        
        store00 = view.findViewById(R.id.idbtstore00);
        store01 = view.findViewById(R.id.idbtstore01);
        store02 = view.findViewById(R.id.idbtstore02);

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
                //passData.passdata(" TEST Pass working");
                try {
                    NavToStoreListener navToStoreListener = (NavToStoreListener) getActivity();
                    navToStoreListener.navToStore("509 Bayfield Street, Barrie, ON L4M 4Z8");
                }catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }
            }
        });

        store01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: store01 clicked");
                try {
                    NavToStoreListener navToStoreListener = (NavToStoreListener) getActivity();
                    navToStoreListener.navToStore("300 Borough Drive #101, Scarborough, ON M1P 4P5");
                }catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }

            }
        });
        store02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: store02 clicked");
                try {
                    NavToStoreListener navToStoreListener = (NavToStoreListener) getActivity();
                    navToStoreListener.navToStore("25 Peel Centre Drive, Brampton, ON L6T 3R5");
                }catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }
            }
        });
        

        return view;
    }
}
