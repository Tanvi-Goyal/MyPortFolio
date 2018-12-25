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
import com.example.tanvi.myportfolio.DataClasses.AchievementsDataClass;
import com.example.tanvi.myportfolio.DataClasses.TrainingsDataClass;
import com.example.tanvi.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.ViewHolder> {

    private List<AchievementsDataClass> mData;
    private LayoutInflater mInflater;

    public AchievementsAdapter(Context context, ArrayList<AchievementsDataClass> achievements) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = achievements;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycler_sample
                , viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        AchievementsDataClass current = mData.get(i);
        viewHolder.title.setText(current.getTitle());
        viewHolder.sub_title.setText(current.getPosition());
        viewHolder.sub_sub_title.setText(current.getTime());
        Glide.with(viewHolder.itemView.getContext()).load(current.getImage()).into(viewHolder.image);

        viewHolder.more.setVisibility(View.GONE);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
