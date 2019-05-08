package com.example.restoreemployeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class FramentMainMenu extends Fragment {
    private static final String TAG = "SEA_Log";
    private Button btnCallManager;
    private Intent callIntent;
    //Menu Items
    private List<MenuItem> menuItems;
    //RecyclerView
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_mainmenu, container, false);

        View view = inflater.inflate(R.layout.fragment_mainmenu, container, false);
        //Create RecyclerView
        try {
            recyclerView = view.findViewById(R.id.mainmenu_recyclerview);
            recyclerView.setHasFixedSize(true);
            //TODO uncomment below later
            recyclerView.setItemViewCacheSize(10);
            recyclerView.setDrawingCacheEnabled(true);
            recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

           recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            //Changed to Grid Layout
            //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            SnapHelperOneByOne snapHelperOneByOne = new SnapHelperOneByOne();
            snapHelperOneByOne.attachToRecyclerView(recyclerView);

        }catch (Exception e){
            Log.d(TAG, "onCreate: RecyclerView Exception " + e);
        }

        // Init menu items list
        menuItems = new ArrayList<>();

        menuItems.add(new MenuItem(
                0,
                "Information",
                R.drawable.info01

        ));

        menuItems.add(new MenuItem(
                1,
                "Training",
                R.drawable.training00

        ));

        menuItems.add(new MenuItem(
                2,
                "Co-Worker's",
                R.drawable.coworkers00

        ));

        menuItems.add(new MenuItem(
                3,
                "Schedule",
                R.drawable.schedule00

        ));

        menuItems.add(new MenuItem(
        4,
                "RE Services",
                R.drawable.allservices00

        ));

        menuItems.add(new MenuItem(
                5,
                "VOIP",
                R.drawable.call00

        ));

        menuItems.add(new MenuItem(
                6,
                "Stats",
                R.drawable.level01

        ));


        try {
            //Recycler view Adapt call
            RecyclerViewAdapterMainMenu adapter = new RecyclerViewAdapterMainMenu(getContext(), menuItems);

            //  adapter.setHasStableIds(true);
            //Setting adapter to RecyclerView
            recyclerView.setAdapter(adapter);
        }catch (Exception e) {
            Log.d(TAG, "onCreate 02: " + e);
        }


        return  view;
    }
}
