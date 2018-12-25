package com.example.tanvi.myportfolio.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tanvi.myportfolio.DataClasses.TechnicalSkillsDataClass;
import com.example.tanvi.myportfolio.R;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;

class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder> {

    ArrayList<TechnicalSkillsDataClass> mData = new ArrayList<>();
    private LayoutInflater mInflater;

    public SkillsAdapter(Context context, ArrayList<TechnicalSkillsDataClass> arrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycler_skill_sample
                , viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.skillName.setText(mData.get(i).getSkill());
        viewHolder.seekBar.setProgress(Integer.parseInt(mData.get(i).getRate()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView skillName ;
        DiscreteSeekBar seekBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            skillName = itemView.findViewById(R.id.skillName);
            seekBar = itemView.findViewById(R.id.skillRate);
        }
    }
}
