package com.example.tanvi.myportfolio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanvi.myportfolio.Adapters.AchievementsAdapter;
import com.example.tanvi.myportfolio.Adapters.EducationAdapter;
import com.example.tanvi.myportfolio.Adapters.ProjectsAdapter;
import com.example.tanvi.myportfolio.Adapters.ResponsiblitiesAdapter;
import com.example.tanvi.myportfolio.Adapters.TechnicalSkillsAdapter;
import com.example.tanvi.myportfolio.Adapters.TrainingsAdapter;
import com.example.tanvi.myportfolio.Adapters.WorkExperienceAdapter;
import com.example.tanvi.myportfolio.DataClasses.AchievementsDataClass;

public class RecyclerFragment extends Fragment {

    EducationAdapter educationAdapter;
    WorkExperienceAdapter workExperienceAdapter;
    ProjectsAdapter projectsAdapter ;
    TechnicalSkillsAdapter technicalSkillsAdapter ;
    TrainingsAdapter trainingsAdapter ;
    AchievementsAdapter achievementsAdapter ;
    ResponsiblitiesAdapter responsiblitiesAdapter;

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

            workExperienceAdapter = new WorkExperienceAdapter(getContext() , ProfileActivity.workExperience);
            recyclerView.setAdapter(workExperienceAdapter);

        }else if(strtext.equals("Projects")) {

            projectsAdapter = new ProjectsAdapter(getContext() , ProfileActivity.projects);
            recyclerView.setAdapter(projectsAdapter);

        }else if(strtext.equals("Technical Skills")) {

            technicalSkillsAdapter = new TechnicalSkillsAdapter(getContext() , ProfileActivity.skills );
            recyclerView.setAdapter(technicalSkillsAdapter);

        }else if(strtext.equals("Trainings")) {

            trainingsAdapter = new TrainingsAdapter(getContext() , ProfileActivity.trainings);
            recyclerView.setAdapter(trainingsAdapter);

        }else if(strtext.equals("Achievements")) {

            achievementsAdapter = new AchievementsAdapter(getContext() , ProfileActivity.achievements);
            recyclerView.setAdapter(achievementsAdapter);

        }else if(strtext.equals("Responsiblities")) {

            responsiblitiesAdapter = new ResponsiblitiesAdapter(getContext() , ProfileActivity.responsiblities);
            recyclerView.setAdapter(responsiblitiesAdapter);
        }

        return view;
    }
}

