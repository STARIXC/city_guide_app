package com.starixc.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView image;
    TextView logo,slogan;
//    Animation topAnim,bottomAnim;
protected int SPLASH_SCREEN = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        image = findViewById(R.id.imageView);
        logo= findViewById(R.id.textView);
        slogan=findViewById(R.id.sloganTxt);
//        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
//        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
//        image.setAnimation(topAnim);
//        logo.setAnimation(bottomAnim);

        super.onCreate(savedInstanceState);
//        remove the status bar from the splash screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,OnBoarding.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}