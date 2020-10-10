package com.starixc.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.starixc.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.starixc.cityguide.HelperClasses.HomeAdapter.FeaturedHealperClass;
import com.starixc.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    RecyclerView featureRecycler;
    RecyclerView.Adapter adapter;

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
        ArrayList<FeaturedHealperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHealperClass(R.drawable.mcd,"Mcdonald's","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        featuredLocations.add(new FeaturedHealperClass(R.drawable.mcd,"Number 2","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        featuredLocations.add(new FeaturedHealperClass(R.drawable.mcd,"number 3","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        adapter = new FeaturedAdapter(featuredLocations);
        featureRecycler.setAdapter(adapter);

    }
}