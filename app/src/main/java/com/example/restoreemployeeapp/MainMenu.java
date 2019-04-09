package com.example.restoreemployeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        callIntent = new Intent (Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("1234567890"));


        btnCallManager = (Button) findViewById(R.id.btn_menu_callmanager);


        btnCallManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(callIntent);
            }
        });

    }
}
