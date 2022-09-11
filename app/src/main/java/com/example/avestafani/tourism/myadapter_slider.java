package com.example.avestafani.tourism;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by AVESTAFANI on 05/08/2022.
 */

public class myadapter_slider extends PagerAdapter {

    List<Integer> list;

    public myadapter_slider(List<Integer> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.image_layout,container,false);
        ImageView image= (ImageView) view.findViewById(R.id.imageview);
        image.setImageResource(list.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);    }
}
