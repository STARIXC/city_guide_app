package com.starixc.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.starixc.cityguide.R;

public class UserDashboard extends AppCompatActivity {
    RecyclerView featureRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //hooks
        featureRecycler = findViewById(R.id.featuredRecycler);
        featuredRecycler();
    }

    private void featuredRecycler() {
        featureRecycler.setHasFixedSize(true);
        //change liner layout from horizontal to vertical
        featureRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }
}