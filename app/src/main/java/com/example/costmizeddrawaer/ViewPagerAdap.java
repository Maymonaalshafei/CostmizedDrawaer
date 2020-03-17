package com.example.costmizeddrawaer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class ViewPagerAdap extends PagerAdapter {
    private List<ViewPagerModel> items;
    private   Context context;
    // constructor
    public ViewPagerAdap(Context context, List<ViewPagerModel> items) {
     this.context=context;
     this.items=items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    public ViewPagerModel getItem(int position) {
        return items.get(position);
    }

    public void setItems(List<ViewPagerModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final ViewPagerModel viewPagerModel = items.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.header, container, false);

        TextView title = (TextView) v.findViewById(R.id.title1);
        LinearLayout background =(LinearLayout) v.findViewById(R.id.background1);

        title.setText(viewPagerModel.getPageName());
        background.setBackgroundResource(viewPagerModel.getBackGroundPhoto());
        ((ViewPager) container).addView(v);
        return v;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }



    }






