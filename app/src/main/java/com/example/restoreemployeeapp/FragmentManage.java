package com.example.restoreemployeeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentManage extends Fragment {
    private static final String TAG = "SEA_Log";

    private List<User> employees;

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_coworkers, container, false);

        recyclerView = view.findViewById(R.id.coworkers_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        employees = new ArrayList<>();

        employees.add(new User(
                "employee00@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        employees.add(new User(
                "employee01@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        employees.add(new User(
                "employee02@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));
        employees.add(new User(
                "employee03@reroyaltrading.ca",
                "First",
                "Last",
                "123",
                "200 Connie Cres",
                "L4K 0K1",
                "647-123-4567"

        ));

        try
        {
            RecyclerViewAdapterUsers adapter = new RecyclerViewAdapterUsers(view.getContext(),employees, passData);

            recyclerView.setAdapter(adapter);
        }catch (Exception e)
        {
            Log.d(TAG, "onCreateView: Exception " + e);
        }


        return view;
    }

    PassData passData = new PassData() {
        @Override
        public void passdata(String string) {
            Log.d(TAG, "passdata: WORKING! " + string);

            FragmentDialogManageExpanded fragmentDialogManageExpanded = new FragmentDialogManageExpanded();
            fragmentDialogManageExpanded.show(getFragmentManager(), "Employees");



        }
    };
}

