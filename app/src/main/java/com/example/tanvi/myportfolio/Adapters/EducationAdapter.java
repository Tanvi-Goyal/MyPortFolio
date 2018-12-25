package com.example.tanvi.myportfolio.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tanvi.myportfolio.DataClasses.EducationDataClass;
import com.example.tanvi.myportfolio.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {

    private List<EducationDataClass> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public EducationAdapter(Context context, ArrayList<EducationDataClass> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_sample
                , parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        EducationDataClass current = mData.get(position);
        holder.title.setText(current.getTitle());
        holder.sub_title.setText(current.getInstitution());
        holder.sub_sub_title.setText(current.getDuration());
        Glide.with(holder.itemView.getContext()).load(current.getImage()).into(holder.image);
//        Uri uri = Uri.parse(current.getCertificate());
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        holder.itemView.getContext().startActivity(intent);

        holder.more.setVisibility(View.GONE);
    }

    // total number of rows
    @Override
    public int getItemCount() {

        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView title , sub_title , sub_sub_title;
        ImageButton certificate , more;
        CircleImageView image;

        ViewHolder(View itemView) {
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