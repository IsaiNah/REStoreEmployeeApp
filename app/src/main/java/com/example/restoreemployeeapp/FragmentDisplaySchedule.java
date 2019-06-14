package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentDisplaySchedule extends Fragment {
    private static final String TAG = "SEA_Log";
    private TextView displayTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_displayerschedule, container);


        displayTextView = (TextView) view.findViewById(R.id.fragmentDisplayTextView);
        displayTextView.setText("Default");

        return view;
    }
}
