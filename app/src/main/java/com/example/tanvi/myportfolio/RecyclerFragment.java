package com.example.tanvi.myportfolio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    EducationAdapter educationAdapter;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        if (savedInstanceState != null)
//        {
//        }
        String strtext = getArguments().getString("activityName");

        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if(strtext.equals("Education")){
            educationAdapter = new EducationAdapter(getContext(), ProfileActivity.education);
//        adapter.setClickListener(view.getContext());
            recyclerView.setAdapter(educationAdapter);

        }else if(strtext.equals("Work Experience")) {

        }else if(strtext.equals("Projects")) {

        }else if(strtext.equals("Technical Skills")) {

        }else if(strtext.equals("Trainings")) {

        }else if(strtext.equals("Achievements")) {

        }else if(strtext.equals("Responsiblities")) {

        }

        return view;
    }
}

