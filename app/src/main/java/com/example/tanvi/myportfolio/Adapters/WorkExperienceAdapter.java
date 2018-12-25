package com.example.tanvi.myportfolio.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tanvi.myportfolio.DataClasses.EducationDataClass;
import com.example.tanvi.myportfolio.DataClasses.WorkExperienceDataClass;
import com.example.tanvi.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class WorkExperienceAdapter extends RecyclerView.Adapter<WorkExperienceAdapter.ViewHolder> {

    private List<WorkExperienceDataClass> mData;
    private LayoutInflater mInflater;
    View alertLayout1;
    ImageView info_image;
    TextView info_title , info_sub_title , info_sub_sub_title , info_description;
    ImageButton info_certificate;

    // data is passed into the constructor
    public WorkExperienceAdapter(Context context, ArrayList<WorkExperienceDataClass> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycler_sample
                , viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final WorkExperienceAdapter.ViewHolder viewHolder, int i) {

        final WorkExperienceDataClass current = mData.get(i);
        viewHolder.title.setText(current.getJob_title());
        viewHolder.sub_title.setText(current.getCompany());
        viewHolder.sub_sub_title.setText(current.getDuration());
        Glide.with(viewHolder.itemView.getContext()).load(current.getImage()).into(viewHolder.image);

        viewHolder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMore(viewHolder.itemView.getContext() , current.getJob_title() , current.getCompany() , current.getDuration() , current.getDescription() , current.getImage() , current.getCertificate());
            }
        });
    }

    private void showMore(Context context, String job_title, String company, String duration, String description, String image, String certificate) {

        LayoutInflater inflater = LayoutInflater.from(context);
        alertLayout1 = inflater.inflate(R.layout.fragment_info, null);
        info_title = alertLayout1.findViewById(R.id.info_title);
        info_sub_title = alertLayout1.findViewById(R.id.info_sub_title);
        info_sub_sub_title = alertLayout1.findViewById(R.id.info_sub_sub_title);
        info_image = alertLayout1.findViewById(R.id.info_image);
        info_certificate = alertLayout1.findViewById(R.id.info_certificate);
        info_description = alertLayout1.findViewById(R.id.info_description);


        info_title.setText(job_title);
        info_sub_title.setText(company);
        info_sub_sub_title.setText(duration);
        info_description.setText(description);
        Glide.with(alertLayout1.getContext()).load(image).into(info_image);


        AlertDialog.Builder alert1 = new AlertDialog.Builder(context);
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

    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView title , sub_title , sub_sub_title;
        ImageButton certificate , more;
        CircleImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            sub_title = itemView.findViewById(R.id.sub_title);
            sub_sub_title = itemView.findViewById(R.id.sub_sub_title);
            certificate = itemView.findViewById(R.id.certificate);
            more = itemView.findViewById(R.id.more);
            image = itemView.findViewById(R.id.img);
        }

    }


}
