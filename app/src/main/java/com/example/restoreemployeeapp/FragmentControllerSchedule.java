package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentControllerSchedule extends Fragment {
    private static final String TAG = "SEA_Log";
    private Button testButton;
   // private TextView displayFragmentTextView;

    BottomSectionControllerListener bottomSectionControllerListener;

    //TODO this interface will be used to control top section
    public interface BottomSectionControllerListener
    {
     void testDataPass(String data);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        try{
            Log.d(TAG, "onAttachFragment:");
            bottomSectionControllerListener = (BottomSectionControllerListener) getContext();
        }catch (Exception e)
        {
            Log.d(TAG, "onAttachFragment: Exception " + e);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controllerschedule, container);

        //TODO check
        final FragmentActivity fragmentActivity = getActivity();

        testButton = view.findViewById(R.id.fragmentLeftButtonAndroid);

       /* try {
            FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
            //Getting FragmentDisplay
            Fragment fragmentDisplay = fragmentManager.findFragmentById(R.id.fragmentDisplay);
            final TextView displayFragmentTextView = fragmentDisplay.getView().findViewById(R.id.fragmentDisplayTextView);
            displayFragmentTextView.setText("BUTTON PRESSED");
        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: Exception " + e);
        }*/
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Controller Fragment Test Button Click");
                try {
                BottomSectionControllerListener bottomSectionControllerListener = (BottomSectionControllerListener) getActivity();
                bottomSectionControllerListener.testDataPass("Data is passing");
                //Setting text in display fragment
                //displayFragmentTextView.setText("BUTTON PRESSED");
                //Getting Textview in Display Fragment in order to change data


                }catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }
            }
        });


        return view;
    }
}
