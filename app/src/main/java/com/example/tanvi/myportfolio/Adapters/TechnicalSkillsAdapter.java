package com.example.tanvi.myportfolio.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tanvi.myportfolio.DataClasses.TechnicalSkillsDataClass;
import com.example.tanvi.myportfolio.ProfileActivity;
import com.example.tanvi.myportfolio.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TechnicalSkillsAdapter extends RecyclerView.Adapter<TechnicalSkillsAdapter.ViewHolder> {
    ArrayList<String> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    View alertLayout1;
    RecyclerView skill_recyler;
    SkillsAdapter skillsAdapter;

    public TechnicalSkillsAdapter(Context context, ArrayList<String> skills) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = skills;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycler_sample_two
                , viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.myTitle.setText(mData.get(i));
        viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSkills(v, i , ProfileActivity.androidlist , ProfileActivity.frameworkslist , ProfileActivity.misclist , ProfileActivity.programminglist , ProfileActivity.weblist);
            }
        });

    }

    private void showSkills(View context , int position , ArrayList<TechnicalSkillsDataClass> androidList , ArrayList<TechnicalSkillsDataClass> frameworksList ,
                            ArrayList<TechnicalSkillsDataClass> miscList , ArrayList<TechnicalSkillsDataClass> programminList , ArrayList<TechnicalSkillsDataClass> webList ){


        LayoutInflater inflater = LayoutInflater.from(context.getContext());
        alertLayout1 = inflater.inflate(R.layout.fragment_skill_recycler, null);
        skill_recyler = alertLayout1.findViewById(R.id.skills_recycler);
        skill_recyler.setLayoutManager(new LinearLayoutManager(context.getContext()));

        ArrayList<TechnicalSkillsDataClass> arrayList = new ArrayList<>();

        if(position == 0){
            arrayList = androidList;
        }else if(position == 1){
            arrayList = frameworksList;
        }else if(position == 2){
            arrayList = miscList;
        }else if(position == 3){
            arrayList = programminList;
        }else if(position == 4){
            arrayList = webList;
        }
        skillsAdapter = new SkillsAdapter(context.getContext() , arrayList);
        skill_recyler.setAdapter(skillsAdapter);


        AlertDialog.Builder alert1 = new AlertDialog.Builder(context.getContext());
        alert1.setTitle("More Information");
        alert1.setView(alertLayout1);
        alert1.setCancelable(true);
        alert1.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                }
        );

        final AlertDialog dialog = alert1.create();
        dialog.show();

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image ;
        TextView myTitle ;
        ImageButton imageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.myImage);
            myTitle = itemView.findViewById(R.id.myTitle);
            imageButton = itemView.findViewById(R.id.myImageButton);
        }
    }
}
