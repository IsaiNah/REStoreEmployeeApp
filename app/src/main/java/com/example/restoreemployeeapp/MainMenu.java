package com.example.restoreemployeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    private static final String TAG = "SEA_Log";
    private Button btnCallManager;
    private Intent callIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);




        btnCallManager = (Button) findViewById(R.id.btn_menu_callmanager);


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
