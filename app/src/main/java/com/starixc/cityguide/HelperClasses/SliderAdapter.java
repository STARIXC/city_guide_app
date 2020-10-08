package com.starixc.cityguide.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.starixc.cityguide.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
//create constructor
    public SliderAdapter(Context context) {
        this.context = context;
    }
    int images[]={
            R.drawable.loc_search,
            R.drawable.call,
            R.drawable.add_place,
            R.drawable.relax,

    };
    int headings[]={
            R.string.first_slide_title,
            R.string.second_slide_title,
            R.string.third_slide_title,
            R.string.fourth_slide_title,
    };
    int desc[]={
            R.string.first_slide_desc,
            R.string.second_slide_desc,
            R.string.third_slide_desc,
            R.string.fourth_slide_desc
    };
//count the number of slides
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(ConstraintLayout) object;
    }
    //initialize images and text

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //use service of design
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //asign
        View view= layoutInflater.inflate(R.layout.slides_layout,container,false);
       //Hooks from design
        ImageView slide_image=view.findViewById(R.id.slider_image);
        TextView slide_title =view.findViewById(R.id.slider_heading);
        TextView slide_desc =view.findViewById(R.id.slider_desc);

        slide_image.setImageResource(images[position]);
        slide_title.setText(headings[position]);
        slide_desc.setText(desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
