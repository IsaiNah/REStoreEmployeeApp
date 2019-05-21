package com.example.restoreemployeeapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class FragmentInformationItem extends Fragment {
    private static final String TAG = " SEA_LOG";

    private Button backButton ,watchButton;
    private TextView collectionTitle, collectionDescription;
    private VideoView collectionVideo;

    private String title, desc, filename;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training_item, container, false);

        // Getting layout items by id
        collectionTitle = view.findViewById(R.id.textview_informationFragmentTitle);
        collectionDescription = view.findViewById(R.id.textview_informationFragmentDescription);
        collectionVideo = view.findViewById(R.id.image_informationFragmentImage);

        collectionDescription.setMovementMethod(new ScrollingMovementMethod());
        //Bundle data
        try{
            //Getting data
            Bundle bundle = getArguments();
            String title = bundle.getString("title");
            //Setting data
            collectionTitle.setText(title);
        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: Exception : " + e);
        }

        //TODO tmp filenmae
        filename = "multi_vitamin_collection";
        //Setting Video
        //String path = "android.resource://" +getActivity().getPackageName().g
        collectionVideo.setVideoURI(Uri.parse( "android.resource://com.example.projectgold/raw/"+filename));
        collectionVideo.start();

  /*      try{
            Bundle bundle =getArguments();
            //Setting variables from bundle
            title = bundle.getString("Title");
            desc = bundle.getString("Description");
            filename = bundle.getString("Filename");
            //imageId = bundle.getInt("Id");

            //Setting data from bundle
            collectionTitle.setText(title);
            collectionDescription.setText(desc);
            //collectionImage.setImageDrawable(getContext().getResources().getDrawable(imageId));
            //Setting Video
            //String path = "android.resource://" +getActivity().getPackageName() + "/" + R.raw.bio_brightening_collection;
            //String path = "android.resource://" +getActivity().getPackageName().g
            collectionVideo.setVideoURI(Uri.parse( "android.resource://com.example.projectgold/raw/"+filename));
            collectionVideo.start();
        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: Exception" + e);
        }*/

      /*  watchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: watchButton");
                *//* FragmentAllCollectionsWatch fragmentAllCollectionsWatch= new FragmentAllCollectionsWatch();
                // FragmentManager fragmentManager=getActivity().getFragmentManager();
                    getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.allcollections_parentLayout, fragmentAllCollectionsWatch, "findThisFragment")
                        .addToBackStack(null)
                        .commit();*//*
                getView().setVisibility(View.GONE);//TODO temp hack
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.allcollections_parentLayout, new FragmentAllCollectionsWatch());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

              *//*  FragmentManager fm = getFragmentManager();
                fm.beginTransaction()
                        .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                        .show(somefrag)
                        .commit();*//*

            }
        });*/



        




        return  view;
    }
    
    

}
