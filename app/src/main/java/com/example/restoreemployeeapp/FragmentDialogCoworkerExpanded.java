package com.example.restoreemployeeapp;



import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class FragmentDialogCoworkerExpanded extends DialogFragment {
    private static final String TAG = "SEA_Log";
    private Button callButton, whatsappButton, messageButton;
    private Intent callIntent, whatsappIntent, messageIntent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragmentdialog_coworkerexpanded, container);

        //Dialog Init for to set Transparent border (removes white around dialog window)
       getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // Gettings items by id
        //backButton = view.findViewById(R.id.);
        callButton = view.findViewById(R.id.idbtmobilecall);
        whatsappButton = view.findViewById(R.id.idbtwhatapp);
        messageButton = view.findViewById(R.id.idbtmessage);



        //Button Listeners
        callButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Call Button Clicked");
                callIntent = new Intent (Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:4161234567"));
                startActivity(callIntent);
            }
        });

        whatsappButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Whatsapp Button Clicked");

                boolean checkWhatsApp = whatsappInstalledOrNot("com.whatsapp");
                Log.d(TAG, "onClick: Whatsapp install check " + checkWhatsApp);
                if (checkWhatsApp)
                {
                    //URI uri = Uri.parse("smsto:" + "14168594316");
                    try {
                  //  android.net.Uri.parse(new java.net.URI("").toString());
                        Uri uri = Uri.parse("smsto:" + "14168594316");
                        whatsappIntent = new Intent(Intent.ACTION_SENDTO, uri);
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,"Test");
                        //whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        startActivity(whatsappIntent);
                    }catch (Exception e )
                    {
                        Log.d(TAG, "URI Exception" + e);
                    }
                }
                else
                {
                    Toast.makeText(getContext(), "Whatsapp Not Installed", Toast.LENGTH_SHORT);
                }

            }
        });

        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Message Button Clicked");
                try {
                    Uri uri = Uri.parse("tel:" + "416859316");
                    messageIntent = new Intent(Intent.ACTION_VIEW, uri);
                    messageIntent.putExtra("sms_body", "sms text");
                    messageIntent.setType("vnd.android-dir/mms-sms");
                    startActivity(messageIntent);
                }
                catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }
            }
        });


        return view;
    }


    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getActivity().getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

}
