package com.example.restoreemployeeapp;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SEA_Log";
    private Button bLogin;
    private TextView registerLink;
    private EditText etEmail, etPass;
    private Intent menuIntent;
    //LocalDB localDataBase;
    static String savedEmail, savedPhone;
    //Url for Database connection script
    final String loginUrl = "http://webdaze.ca/RELogin.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bLogin =(Button) findViewById(R.id.idbtLogin);
   // registerLink = (TextView) findViewById(R.id.idRegisterLink);
    etEmail = (EditText) findViewById(R.id.idetEmail);
    etPass = (EditText) findViewById(R.id.idetPassword);

    menuIntent = new Intent(MainActivity.this, MainMenu.class);



    bLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "\n Email : " + etEmail.getText().toString() + ", Password : " + etPass.getText().toString());

            User user = new User(etEmail.getText().toString(), etPass.getText().toString());

            //TODO Add Local DataBase?

            // userLogin method Checking
            userFieldCheck(user);

            //Volley for database Connection
            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            // Request and Response with Error handling
            StringRequest stringRequest = new StringRequest(Request.Method.POST, loginUrl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if (success)
                                {
                                    Log.d(TAG, "onResponse: Success");



                                    //TODO this area will determine employee level and show different menu accordingly
                                    try {
                                        startActivity(menuIntent);
                                    }catch(Exception e)
                                    {
                                        Log.d(TAG, "onResponse: StartActivity Exception " + e);
                                    }

                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_SHORT);
                                }
                            } catch (JSONException e) {
                                Log.d(TAG, "JSONE Response exception : " + e);
                            }
                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                   // error.printStackTrace(); //TODO tutorial
                }
            }

            )  {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("email", etEmail.getText().toString());
                    params.put("password", etPass.getText().toString());
                    return params;
                }
            };




            requestQueue.add(stringRequest);

            //menuIntent = new Intent(MainActivity.this, )

       /*     if (etEmail.getText().toString().equals("driver")) //
            {
                Log.d(TAG,"Driver true : " + etEmail.getText().toString() );
                Intent intent = new Intent(Login.this, DriverMainActivity.class);
                startActivity(intent);
            }else {
                Log.d(TAG,"Driver false : " + etEmail.getText().toString());
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }//End of sorting area
        }else //Failed to login
        {
            Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_SHORT);

        }
    }catch(JSONException e)
        {
            Log.d(TAG, "JSONE Response exception : " + e);
        }*/


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



