package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentInformation extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button backButton;
    private ListView listView;

//    String[] listViewString = {"1" , "2", "3" , "4", "5"};

    ArrayAdapter arrayAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container);

        // Getting Items by id
        backButton = view.findViewById(R.id.btn_back);

        listView = (ListView) view.findViewById(R.id.information_listview);

        //TODO change this to other way of doing
        // Information Init
        Information welcome = new Information("Welcome", "Incomplete", "Date: 2019/01/01");
        Information orientation = new Information("Orientation", "Incomplete", "Date: 2019/01/01");
        Information schedule = new Information("How To Check My Work Schedule", "Incomplete", "Date: 2019/01/01");
        //Information = new Information("How To Check My Work Schedule", "Incomplete", "Date: 2019/01/01");

        ArrayList<Information> informationList = new ArrayList<>();

        informationList.add(welcome);
        informationList.add(orientation);
        informationList.add(schedule);

    //arrayAdapter = new ArrayAdapter(this, and)
        //try {
          //  InformationListAdatper adapter = new InformationListAdatper(getActivity(), R.layout.listview_informationadapter);
       /* }
        catch(Exception e)
        {
            Log.d(TAG, "onCreateView: Exception " + e);
        }*/
      // listView.setAdapter(adapter);

      //  listView.setAdapter(new InformationListAdatper(getActivity(),R.layout.listview_informationadapter ));

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
