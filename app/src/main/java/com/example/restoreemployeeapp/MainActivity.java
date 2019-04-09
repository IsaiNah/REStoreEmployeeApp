package com.example.restoreemployeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SEA_Log";
    private Button bLogin;
    private TextView registerLink;
    private EditText etEmail, etPass;
    //LocalDB localDataBase;
    static String savedEmail, savedPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bLogin =(Button) findViewById(R.id.idbtLogin);
    registerLink = (TextView) findViewById(R.id.idRegisterLink);
    etEmail = (EditText) findViewById(R.id.idetEmail);
    etPass = (EditText) findViewById(R.id.idetPassword);

    bLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "\n Email : " + etEmail.getText().toString() + ", Password : " + etPass.getText().toString());

            User user = new User(etEmail.toString(), etPass.toString());

            //TODO Add Local DataBase?

            // userLogin method Checking
            userFieldCheck(user);

            //Volley for database Connection
           // Request requestQueue = Volley.newR



        }
    });


}



    //User field check
    private void userFieldCheck(User user) {
        //Validation of userfields
        //Empty
        if (TextUtils.isEmpty(etEmail.getText().toString())) {
            etEmail.setError("Please enter your Email");
            etEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(etPass.getText().toString())) {
            etPass.setError("Please enter your password");
            etPass.requestFocus();
            return;
        }

    }}
