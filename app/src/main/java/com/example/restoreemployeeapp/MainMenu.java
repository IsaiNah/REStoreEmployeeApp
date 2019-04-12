package com.example.restoreemployeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    private static final String TAG = "SEA_Log";
    private Button btnCallManager;
    private Intent callIntent;
    //Menu Items
    private List<MenuItem> menuItems;
    //RecyclerView
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btnCallManager = (Button) findViewById(R.id.btn_menu_callmanager);



        //Create RecyclerView
        try {
            recyclerView = findViewById(R.id.mainmenu_recyclerview);
            recyclerView.setHasFixedSize(true);
            //TODO uncomment below later
            recyclerView.setItemViewCacheSize(10);
            recyclerView.setDrawingCacheEnabled(true);
            recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

            //recyclerView.setLayoutManager(new LinearLayoutManager(this));
            //Changed to Grid Layout
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }catch (Exception e){
            Log.d(TAG, "onCreate: RecyclerView Exception " + e);
        }

        // Init menu items list
        menuItems = new ArrayList<>();

        menuItems.add(new MenuItem(
                0,
                "Information",
                R.drawable.info00

        ));
        menuItems.add(new MenuItem(
                1,
                "VOIP Call",
                R.drawable.call01

        ));
        menuItems.add(new MenuItem(
                2,
                "Contacts",
                R.drawable.contacts01

        ));
        menuItems.add(new MenuItem(
                3,
                "RE Services",
                R.drawable.allservices00

        ));
        menuItems.add(new MenuItem(
                4,
                "Training",
                R.drawable.training00

        ));
        menuItems.add(new MenuItem(
                5,
                "Certificate Quiz",
                R.drawable.quiz02

        ));
        menuItems.add(new MenuItem(
                6,
                "My Stats",
                R.drawable.level01

        ));



        try {
            //Recycler view Adapt call
            RecyclerViewAdapterMainMenu adapter = new RecyclerViewAdapterMainMenu(this, menuItems);

            //  adapter.setHasStableIds(true);
            //Setting adapter to RecyclerView
            recyclerView.setAdapter(adapter);
        }catch (Exception e) {
            Log.d(TAG, "onCreate 02: " + e);
        }

        btnCallManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    callIntent = new Intent (Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:123456789"));
                    startActivity(callIntent);
                }catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }
            }
        });

    }
}
