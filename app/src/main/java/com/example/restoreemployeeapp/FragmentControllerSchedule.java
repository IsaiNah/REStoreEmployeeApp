package com.example.restoreemployeeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FragmentControllerSchedule extends Fragment {
    private static final String TAG = "SEA_Log";
    private Button testButton;
   // private TextView displayFragmentTextView;

    private RecyclerView recyclerView;

    private List<User> userList;
    private List<Store> storeList;

    BottomSectionControllerListener bottomSectionControllerListener;

    //TODO this interface will be used to control top section
    public interface BottomSectionControllerListener
    {
     void testDataPass(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            bottomSectionControllerListener = (BottomSectionControllerListener) context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controllerschedule, container);

        //TODO check
        //final FragmentActivity fragmentActivity = getActivity();

        testButton = view.findViewById(R.id.idbtControllerStoreSelector);

        //Setting up RecyclerView
        recyclerView = view.findViewById(R.id.schedule_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //TODO For Testing Load From File / DataBase

        storeList = new ArrayList<>();

        storeList.add(new Store(
                "OroGold Scarborough",
                "300 Borough Drive #101",
                "M1P 4P5",
                "647-123-4567"
        ));
        storeList.add(new Store(
                "OroGold Brampton",
                "25 Peel Centre Drive",
                "L6T 3R5",
                "647-123-4567"
        ));
        storeList.add(new Store(
                "OroGold Barrie",
                "509 Bayfield Street",
                "L4M 4Z8",
                "647-123-4567"
        ));


        userList = new ArrayList<>();

        userList.add(new User(
                "employee00@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userList.add(new User(
                "employee01@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userList.add(new User(
                "employee02@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        userList.add(new User(
                "employee03@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));

        // Calling RecyclerView adapter
        RecyclerViewAdapterUsers adapterUsers = new RecyclerViewAdapterUsers(view.getContext(), userList, passData);


        //TODO Set Different Adapters According to which Button Was Selected
        recyclerView.setAdapter(adapterUsers);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Controller Fragment Test Button Click");
                try {
                bottomSectionControllerListener.testDataPass("Data is passing");
                }catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }
            }
        });


        return view;
    }

    PassData passData = new PassData() {
        @Override
        public void passdata(String string) {
            Log.d(TAG, "passdata: WORKING! " + string);
            //TODO unused interface set in order to call AdapterUsers for  Testing
        }
    };
}
