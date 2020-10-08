package com.starixc.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.starixc.cityguide.HelperClasses.SliderAdapter;
import com.starixc.cityguide.R;

public class OnBoarding extends AppCompatActivity {
ViewPager viewPager;
LinearLayout dotsLayout;

SliderAdapter sliderAdapter;
TextView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        viewPager= findViewById(R.id.slider);
        dotsLayout= findViewById(R.id.dots);

        //call slider adapter
        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);
        addDots();
    }
private void addDots(){
        dots = new TextView[4];
        for (int i=0; i<dots.length; i++){
            dots[i]= new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
}

}