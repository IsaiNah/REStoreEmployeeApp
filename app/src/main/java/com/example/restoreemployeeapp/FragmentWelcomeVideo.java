package com.example.restoreemployeeapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;


public class FragmentWelcomeVideo extends Fragment{
    private static final String TAG = "SEA_Log";
    private Button continueButton;
    private VideoView videoView;
    private String filename;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcomevideo, container, false);


        // Deactivating Drawer
        ((DrawerLocker)getActivity()).setDrawerEnabled(false);
        continueButton = view.findViewById(R.id.idbtwelcomevideonext);

        videoView = view.findViewById(R.id.idvideowelcome);

        filename = "multi_vitamin_collection";
        //Setting Video
        //String path = "android.resource://" +getActivity().getPackageName().g
        videoView.setVideoURI(Uri.parse( "android.resource://com.example.projectgold/raw/"+filename));
        videoView.start();
        continueButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Log.d(TAG, "onClick: Continue Clicked");
                                                  FragmentWelcomeText fragmentWelcomeText = new FragmentWelcomeText();
                                                  getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                                          fragmentWelcomeText).commit();
                                              }
                                          }
        );

        return view;
    }
}

/*
public class FragmentWelcomeVideo extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button continueButton;
    private VideoView videoView;
    private String filename;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcomevideo,container);

        continueButton  = view.findViewById(R.id.idbtwelcomevideonext);
        videoView = view.findViewById(R.id.idvideowelcome);
        videoView.setZOrderOnTop(true);

        //TODO tmp video
        filename = "multi_vitamin_collection";
        //Setting Video
        //String path = "android.resource://" +getActivity().getPackageName().g
        videoView.setVideoURI(Uri.parse( "android.resource://com.example.projectgold/raw/"+filename));
        videoView.start();
        
        
        
        
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
*/
