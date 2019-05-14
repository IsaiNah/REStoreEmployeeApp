package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FragmentInformation extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button backButton;
    private List<Information> informationList;
    private RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container);

        // Getting Items by id
        backButton = view.findViewById(R.id.btn_back);

        //listView = (ListView) view.findViewById(R.id.information_listview);

        //Setting up recyclerview
        try{
            recyclerView = view.findViewById(R.id.fraginfo_recyclerview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: RecyclerView Exception " + e);
        }

        //Creating information list
        informationList = new ArrayList<>();

        informationList.add(new Information(
                0,
                "Welcome",
                "Click here to begin",
                "Incomplete"

        ));
        informationList.add(new Information(
                1,
                "Orientation",
                "Welcome to the team",
                "Incomplete"

        ));
        informationList.add(new Information(
                2,
                "Navigation",
                "Information to help you find your way",
                "Incomplete"

        ));

        //Recycler View adapter to attach list into
        try{
            RecyclerViewAdapterInformation adapter = new RecyclerViewAdapterInformation(view.getContext(),informationList,passData);
            recyclerView.setAdapter(adapter);
        }catch (Exception e){
            Log.d(TAG, "onCreateView: " + e);
        }


        

        // Closing fragment
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              //  ((MainMenu)getActivity()).TransFragmentInformationItem();
               getDialog().dismiss();

            }
        });

        return view;
    }

   /* @Override
    public void passdata(String string) {
        Log.d(TAG, "passdata: WORKING!!!!!!! " + string);
    }*/

   PassData passData = new PassData() {
       @Override
       public void passdata(String string) {
           Log.d(TAG, "passdata: WORKING!!!!!!! " + string);

           //TODO either change interface to accept more strings or extract data form single string with space or | seperators

           FragmentInformationItem fragmentInformationItem = new FragmentInformationItem();//TODO Pass Data Here
           // Bundle to pass data into onCreateView method of fragment
           Bundle bundle = new Bundle();
           bundle.putString("title", string);
           // Adding data to fragment
           fragmentInformationItem.setArguments(bundle);
           FragmentManager manager = getFragmentManager();
           FragmentTransaction transaction = manager.beginTransaction();
           transaction.replace(R.id.mainmenu, fragmentInformationItem).commit();
           getDialog().dismiss();
       }
   };

}

