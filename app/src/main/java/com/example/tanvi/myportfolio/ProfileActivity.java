package com.example.tanvi.myportfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.tanvi.myportfolio.DataClasses.AchievementsDataClass;
import com.example.tanvi.myportfolio.DataClasses.EducationDataClass;
import com.example.tanvi.myportfolio.DataClasses.ProjectsDataClass;
import com.example.tanvi.myportfolio.DataClasses.ResponsiblitiesDataClass;
import com.example.tanvi.myportfolio.DataClasses.TechnicalSkillsDataClass;
import com.example.tanvi.myportfolio.DataClasses.TrainingsDataClass;
import com.example.tanvi.myportfolio.DataClasses.ViewPagerDataClass;
import com.example.tanvi.myportfolio.DataClasses.WorkExperienceDataClass;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;
    ArrayList<String> arr = new ArrayList<>();
    public static ArrayList<String> skills = new ArrayList<>();
    public static ArrayList<String> skillsImage = new ArrayList<>();
    public static ArrayList<AchievementsDataClass> achievements = new ArrayList<>();
    public static ArrayList<EducationDataClass> education = new ArrayList<>();
    public static ArrayList<ProjectsDataClass> projects = new ArrayList<>();
    public static ArrayList<ResponsiblitiesDataClass> responsiblities = new ArrayList<>();
    public static ArrayList<TrainingsDataClass> trainings = new ArrayList<>();
    public static ArrayList<ViewPagerDataClass> viewpager = new ArrayList<>();
    public static ArrayList<WorkExperienceDataClass> workExperience = new ArrayList<>();
    public static ArrayList<TechnicalSkillsDataClass> androidlist = new ArrayList<>();
    public static ArrayList<TechnicalSkillsDataClass> frameworkslist = new ArrayList<>();
    public static ArrayList<TechnicalSkillsDataClass> misclist = new ArrayList<>();
    public static ArrayList<TechnicalSkillsDataClass> programminglist = new ArrayList<>();
    public static ArrayList<TechnicalSkillsDataClass> weblist = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(this);


        drawer = findViewById(R.id.drawer_main);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(ProfileActivity.this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AboutFragment()).commit();
        }

        addItems( skills , arr);

    }

    private void addItems( final ArrayList<String> strings, final ArrayList<String> arr) {


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    arr.add(child.getKey());
                }

                fetchData(arr);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("Technical Skills").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    strings.add(child.getKey());

                }
                Log.wtf("TAG" , strings.toString() );

                fetchSkillsData(strings);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    private void fetchSkillsData(ArrayList<String> strings) {


        Log.wtf("TAG" , strings.toString() );

        for(int i = 0 ; i< strings.size() ; i++){
            Log.wtf("TAG" , strings.get(i) );
            final int finalI = i;
            AndroidNetworking.get("https://floating-caverns-30742.herokuapp.com/Technical Skills/" + strings.get(finalI))

                    .build().getAsJSONArray(new JSONArrayRequestListener() {
                @Override
                public void onResponse(JSONArray response) {
                    Log.wtf("TAG", String.valueOf(response));
                    if(finalI == 0){
                        androidlist = new Gson().fromJson(response.toString(), new TypeToken<List<TechnicalSkillsDataClass>>() {}.getType());
                    }
                    if(finalI == 1){
                        frameworkslist = new Gson().fromJson(response.toString(), new TypeToken<List<TechnicalSkillsDataClass>>() {}.getType());
                    }
                    if(finalI == 2){
                        misclist = new Gson().fromJson(response.toString(), new TypeToken<List<TechnicalSkillsDataClass>>() {}.getType());
                    }
                    if(finalI == 3){
                        programminglist = new Gson().fromJson(response.toString(), new TypeToken<List<TechnicalSkillsDataClass>>() {}.getType());
                    }
                    if(finalI == 4){
                        weblist = new Gson().fromJson(response.toString(), new TypeToken<List<TechnicalSkillsDataClass>>() {}.getType());
                    }


                }

                @Override
                public void onError(ANError anError) {

                }
            });

        }
    }

    private void fetchData(ArrayList<String> myArr) {

        for(int i = 0 ; i < myArr.size() ; i++) {
            String str = myArr.get(i);
            final int finalI = i;
            AndroidNetworking.get("https://floating-caverns-30742.herokuapp.com/" + str)

                    .build().getAsJSONArray(new JSONArrayRequestListener() {
                @Override
                public void onResponse(JSONArray response) {
//                    Log.wtf("TAG", String.valueOf(response));
                    if(finalI == 0){
                        achievements = new Gson().fromJson(response.toString(), new TypeToken<List<AchievementsDataClass>>() {}.getType());
                    }
                    if(finalI == 1){
                        education = new Gson().fromJson(response.toString(), new TypeToken<List<EducationDataClass>>() {}.getType());
                    }
                    if(finalI == 2){
                        projects = new Gson().fromJson(response.toString(), new TypeToken<List<ProjectsDataClass>>() {}.getType());
                    }
                    if(finalI == 3){
                        responsiblities = new Gson().fromJson(response.toString(), new TypeToken<List<ResponsiblitiesDataClass>>() {}.getType());
                    }
                    if(finalI == 4){
//                        achievements = new Gson().fromJson(response.toString(), new TypeToken<List<AchievementsDataClass>>() {}.getType());
                    }
                    if(finalI == 5){
                        trainings = new Gson().fromJson(response.toString(), new TypeToken<List<TrainingsDataClass>>() {}.getType());
                    }
                    if(finalI == 6){
                        viewpager = new Gson().fromJson(response.toString(), new TypeToken<List<ViewPagerDataClass>>() {}.getType());
                    }
                    if(finalI == 7){
                        workExperience = new Gson().fromJson(response.toString(), new TypeToken<List<WorkExperienceDataClass>>() {}.getType());
                    }

                }

                @Override
                public void onError(ANError anError) {

                }
            });

        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Bundle bundle = new Bundle();
        Fragment fragment = null;
        switch (menuItem.getItemId()) {

            case R.id.about_me:
                fragment = new AboutFragment();
                break;

            case R.id.resume:
                Uri uri = Uri.parse("https://drive.google.com/open?id=1TU4qCQ40ZfNcJsuCDXrx6NqcsHUnhCut"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.education:
                bundle.putString("activityName", "Education");
                fragment = new RecyclerFragment();
                fragment.setArguments(bundle);
                break;

            case R.id.work_experience:
                bundle.putString("activityName", "Work Experience");
                fragment = new RecyclerFragment();
                fragment.setArguments(bundle);
                break;
            case R.id.projects:
                bundle.putString("activityName", "Projects");
                fragment = new RecyclerFragment();
                fragment.setArguments(bundle);
                break;

            case R.id.skills:
                bundle.putString("activityName", "Technical Skills");
                fragment = new RecyclerFragment();
                fragment.setArguments(bundle);
                break;

            case R.id.trainings:
                bundle.putString("activityName", "Trainings");
                fragment = new RecyclerFragment();
                fragment.setArguments(bundle);
                break;

            case R.id.achievements:
                bundle.putString("activityName", "Achievements");
                fragment = new RecyclerFragment();
                fragment.setArguments(bundle);
                break;

            case R.id.responsiblities:
                bundle.putString("activityName", "Responsiblities");
                fragment = new RecyclerFragment();
                fragment.setArguments(bundle);
                break;

            case R.id.message:
//                bundle.putString("activityName", "Education");
//                fragment = new RecyclerFragment();
//                fragment.setArguments(bundle);
                break;

            case R.id.follow:
//                bundle.putString("activityName", "Education");
//                fragment = new RecyclerFragment();
//                fragment.setArguments(bundle);
                break;


        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);ft.commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
