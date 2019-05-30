package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.style.BulletSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentAccount extends Fragment {
    private static final String TAG = "SEA_Log";

    private TextView userFirst, userLast, userEmail, userPhone, userAddress;
    private Button changePass, changeAddress;
    private BulletSpan langEng, langRus, langHeb;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        userFirst = view.findViewById(R.id.txt_userFName);
        userLast = view.findViewById(R.id.txt_userLName);
        userPhone = view.findViewById(R.id.txt_userPhone);
        userEmail = view.findViewById(R.id.txt_userEmail);
        userAddress = view.findViewById(R.id.txt_userAddress);
        
        
        changeAddress = view.findViewById(R.id.btnChangeAddress);
        changePass = view.findViewById(R.id.btnChangePass);
        
        
        
        changeAddress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Change Address Clicked");
            }
        });
        
        changePass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Change Password Clicked");
            }
        });

        


        return view;
    }
}
