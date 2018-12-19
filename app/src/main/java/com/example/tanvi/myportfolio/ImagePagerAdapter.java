package com.example.tanvi.myportfolio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class ImagePagerAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;
    ArrayList<String> imagesList , titleList , textsList;

    public ImagePagerAdapter(AboutFragment aboutFragment, ArrayList<String> images, ArrayList<String> titles, ArrayList<String> texts) {
        this.context = aboutFragment.getContext();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imagesList = images;
        this.textsList = texts ;
        this.titleList = titles;

    }

    @Override
    public int getCount() {
        if(imagesList != null){
            return imagesList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (o);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.viewpager_sample, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.pagerImage);
        TextView title = itemView.findViewById(R.id.pagertitle);
        TextView text = itemView.findViewById(R.id.pagertext);

        Glide.with(context).load(imagesList.get(position))
                .into(imageView);
        title.setText(titleList.get(position));
        text.setText(textsList.get(position));

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
