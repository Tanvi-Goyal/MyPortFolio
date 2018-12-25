package com.example.tanvi.myportfolio.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tanvi.myportfolio.DataClasses.EducationDataClass;
import com.example.tanvi.myportfolio.DataClasses.TrainingsDataClass;
import com.example.tanvi.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TrainingsAdapter extends RecyclerView.Adapter<TrainingsAdapter.ViewHolder> {

    private List<TrainingsDataClass> mData;
    private LayoutInflater mInflater;

    public TrainingsAdapter(Context context, ArrayList<TrainingsDataClass> trainings) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = trainings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycler_sample
                , viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingsAdapter.ViewHolder viewHolder, int i) {

        TrainingsDataClass current = mData.get(i);
        viewHolder.title.setText(current.getTitle());
        viewHolder.sub_title.setText(current.getCompany());
        viewHolder.sub_sub_title.setText(current.getDuration());
        Glide.with(viewHolder.itemView.getContext()).load(current.getImage()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title , sub_title , sub_sub_title;
        ImageButton certificate;
        CircleImageView image;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            title = itemView.findViewById(R.id.title);
            sub_title = itemView.findViewById(R.id.sub_title);
            sub_sub_title = itemView.findViewById(R.id.sub_sub_title);
            certificate = itemView.findViewById(R.id.certificate);
            image = itemView.findViewById(R.id.img);

        }
    }
}
