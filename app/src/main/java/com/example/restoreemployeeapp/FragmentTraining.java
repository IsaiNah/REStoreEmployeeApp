package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTraining extends Fragment {
    private static final String TAG = "SEA_Log";
    private Button btnBack;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        
        View view = inflater.inflate(R.layout.fragment_training, container, false);
        
        btnBack = (Button) view.findViewById(R.id.btn_train_back);
        
        
        
        
        
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Fragment Training Back Clicked");
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentMainMenu());
            }
        });
        
        return view;
    }
}
