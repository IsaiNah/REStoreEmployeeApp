package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentSelectSellers extends Fragment {

    private static final String TAG = "SEA_Log";
    private TextView typeOfSeller;

    //List of Other Users
    private List<User> userlist;

    // RecyclerView
    private RecyclerView recyclerView;

    private Button acceptSellers;

    // TODO Change to Single Interface to change all Fragments
    private PassData passData;

    public interface ConfirmSellerListener{
        void sellerConfirm(String type);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_selectsellers, container, false);

        //Getting data from Bundle
        Bundle bundle = getArguments();
        String type = bundle.getString("Type");
        Log.d(TAG, "onCreateView: Employee Type from Bundle : " + type);

        // Getting Items by id
        typeOfSeller = view.findViewById(R.id.idtxtSelectSellers);
        acceptSellers = view.findViewById(R.id.idbtacceptseller);
       // backButton = view.findViewById(R.id.btn_back);

        //Getting Recyclerview from XML
        recyclerView = view.findViewById(R.id.selectSellers_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        
       typeOfSeller.setText(type + " Sellers");


        //TODO Load from DataBase
        //Init userlist
        userlist = new ArrayList<>();

        //TODO TMP, Will Be Loaded From File / DataBase
        switch (type)
        {
            case "Gold":
                Log.d(TAG, "Case Gold");
                userlist.add(new User(
                        "gold00@reroyaltrading.ca",
                        "FirstName",
                        "Gold",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                userlist.add(new User(
                        "employee01@reroyaltrading.ca",
                        "FirstName",
                        "Gold",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                userlist.add(new User(
                        "employee02@reroyaltrading.ca",
                        "FirstName",
                        "Gold",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                break;
            case "Silver":
                Log.d(TAG, "Case Silver");
                userlist.add(new User(
                        "silver00@reroyaltrading.ca",
                        "FirstName",
                        "Silver",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                userlist.add(new User(
                        "silver01@reroyaltrading.ca",
                        "FirstName",
                        "Silver",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                userlist.add(new User(
                        "silver02@reroyaltrading.ca",
                        "FirstName",
                        "Silver",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                userlist.add(new User(
                        "silver03@reroyaltrading.ca",
                        "FirstName",
                        "Silver",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                break;
            case "Bronze":
                Log.d(TAG, "Case Bronze");   Log.d(TAG, "Case Silver");
                userlist.add(new User(
                        "bronze00@reroyaltrading.ca",
                        "FirstName",
                        "Bronze",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                userlist.add(new User(
                        "bronze01@reroyaltrading.ca",
                        "FirstName",
                        "Bronze",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                userlist.add(new User(
                        "bronze02@reroyaltrading.ca",
                        "FirstName",
                        "Bronze",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));
                userlist.add(new User(
                        "bronze03@reroyaltrading.ca",
                        "FirstName",
                        "Bronze",
                        "123",
                        "200 Connie Cres",
                        "L4K 0K1",
                        "647-123-4567"

                ));

                break;
        }


        try {
            //Recycler view Adapt call
            RecyclerViewAdapterSellers adapter =new RecyclerViewAdapterSellers(view.getContext(),userlist/*, passData*/);

            //Setting adapter to RecyclerView
            recyclerView.setAdapter(adapter);
        }catch (Exception e) {
            Log.d(TAG, "onCreate 02: " + e);
        }

        // Closing fragment
       /* backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              //  getDialog().dismiss();
            }
        });*/
       
       //Accept button listener
        acceptSellers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Accept Clicked");
                    //TODO interface
                    try {
                   FragmentDialogSellerConfirm fragmentDialogSellerConfirm = new FragmentDialogSellerConfirm();
                   fragmentDialogSellerConfirm.show(getFragmentManager(), "Seller confirm");
                    }catch (Exception e)
                    {
                        Log.d(TAG, "onClick: Exception " + e);
                    }
            }
        });
       

        return view;
    }


}
