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
import android.widget.VideoView;

public class FragmentWelcomeVideo extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button continueButton;
    private VideoView videoView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcomevideo,container);

        continueButton  = view.findViewById(R.id.idbtwelcomevideonext);
        videoView = view.findViewById(R.id.idvideowelcome);


        
        
        
        
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Continue Clicked");

                getDialog().dismiss();
            }
            }
        );

        return view;
    }
}
