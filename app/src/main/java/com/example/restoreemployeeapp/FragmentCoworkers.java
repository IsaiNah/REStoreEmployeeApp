package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FragmentCoworkers extends Fragment {

    private static final String TAG = "SEA_Log";
    private Button backButton;

    //List of Other Users
    private List<User> userlist;

    // RecyclerView
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coworkers, container, false);

        //Dialog Init for to set Transparent border

        // Getting Items by id
        backButton = view.findViewById(R.id.btn_back);

        //Getting Recyclerview from XML
        recyclerView = view.findViewById(R.id.coworkers_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        //TODO Load from DataBase
        //Init userlist
        userlist = new ArrayList<>();

        userlist.add(new User(
               "employee00@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userlist.add(new User(
                "employee01@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userlist.add(new User(
                "employee02@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userlist.add(new User(
                "employee03@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));

        try {
            //Recycler view Adapt call
            RecyclerViewAdapterUsers adapter =new RecyclerViewAdapterUsers(view.getContext(),userlist, passData);

            //Setting adapter to RecyclerView
            recyclerView.setAdapter(adapter);
        }catch (Exception e) {
            Log.d(TAG, "onCreate 02: " + e);
        }

        // Closing fragment
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              //  getDialog().dismiss();
            }
        });

        return view;
    }

    PassData passData = new PassData() {
        @Override
        public void passdata(String string) {
            Log.d(TAG, "passdata: WORKING! " + string);

            FragmentDialogCoworkerExpanded fragmentDialogCoworkerExpanded = new FragmentDialogCoworkerExpanded();
            fragmentDialogCoworkerExpanded.show(getFragmentManager(), "Users");

            //TODO either change interface to accept more strings or extract data form single string with space or | seperators

      /*      FragmentInformationItem fragmentInformationItem = new FragmentInformationItem();//TODO Pass Data Here
            // Bundle to pass data into onCreateView method of fragment
            Bundle bundle = new Bundle();
            bundle.putString("title", string);
            // Adding data to fragment
            fragmentInformationItem.setArguments(bundle);
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.mainmenu, fragmentInformationItem).commit();
            getDialog().dismiss();*/
        }
    };

}
