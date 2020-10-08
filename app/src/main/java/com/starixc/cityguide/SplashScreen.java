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

import com.starixc.cityguide.Common.OnBoarding;
import com.starixc.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
//    variables
    ImageView image;
    TextView logo,slogan;
    // Animations
    Animation sideAnim,bottomAnim;
private static int SPLASH_SCREEN = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
//        remove the status bar from the splash screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

       // hooks
        image = findViewById(R.id.imageView);
        logo= findViewById(R.id.textView);
        slogan=findViewById(R.id.sloganTxt);
        // animation
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        //set  Animations on Elements
        image.setAnimation(sideAnim);
        logo.setAnimation(bottomAnim);

        //animation Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}