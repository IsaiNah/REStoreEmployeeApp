package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentInformation extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button backButton;
    private List<Information> infomrationList;
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
        infomrationList = new ArrayList<>();

        infomrationList.add(new Information(
                0,
                "Welcome",
                "Click here to begin",
                "Incomplete"

        ));
        infomrationList.add(new Information(
                1,
                "Orientation",
                "Welcome to the team",
                "Incomplete"

        ));
        infomrationList.add(new Information(
                2,
                "Navigation",
                "Information to help you find your way",
                "Incomplete"

        ));

        //Recycler View adapter to attach list into
        try{
            RecyclerViewInformationAdapter adapter = new RecyclerViewInformationAdapter(view.getContext(),infomrationList);
            recyclerView.setAdapter(adapter);
        }catch (Exception e){
            Log.d(TAG, "onCreateView: " + e);
        }




        // Closing fragment
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
}
