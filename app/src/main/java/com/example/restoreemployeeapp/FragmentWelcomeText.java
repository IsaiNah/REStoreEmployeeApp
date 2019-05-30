package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentWelcomeText extends Fragment {
    private static final String TAG = "SEA_Log";
    private Button continueButton;
    private TextView informationText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcometext, container, false);

        continueButton = view.findViewById(R.id.idbtwelcometextnext);
        informationText = view.findViewById(R.id.idinformationtext);

try {
    informationText.setMovementMethod(new ScrollingMovementMethod());
}catch (Exception e)
{
    Log.d(TAG, "onCreateView: Exception " + e);
}
        
        continueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ContinueInformationButton clicked");

                FragmentMainView fragmentMainView = new FragmentMainView();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragmentMainView).commit();
            }
        });
        
        
        return view;
    }
}
