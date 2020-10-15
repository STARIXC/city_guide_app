package com.starixc.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.starixc.cityguide.HelperClasses.HomeAdapter.CategoryAdapter;
import com.starixc.cityguide.HelperClasses.HomeAdapter.CategoryHelperClass;
import com.starixc.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.starixc.cityguide.HelperClasses.HomeAdapter.FeaturedHealperClass;
import com.starixc.cityguide.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.starixc.cityguide.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.starixc.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    RecyclerView featureRecycler,mostviewedRecycler,catRecycler;
    RecyclerView.Adapter adapter,adt,catAdt;
    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //icon menu




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //hooks
        featureRecycler = findViewById(R.id.featuredRecycler);
        mostviewedRecycler = findViewById(R.id.mostviewedRecycler);
        catRecycler = findViewById(R.id.catRecycler);
//        menu hooks
        drawerLayout= findViewById(R.id.drawer_lt);
        navigationView= findViewById(R.id.drawer_menu);

        featuredRecycler();
        mostviewedRecycler();
        catRecycler();
    }

    private void catRecycler() {
        catRecycler.setHasFixedSize(true);
        catRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<CategoryHelperClass> categoryList = new ArrayList<>();
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img,"Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img,"Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img,"Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img,"Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img,"Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img,"Restaurant"));
        catAdt = new CategoryAdapter(categoryList);
        catRecycler.setAdapter(catAdt);
    }

    private void mostviewedRecycler() {
        mostviewedRecycler.setHasFixedSize(true);
        mostviewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        ArrayList<MostViewedHelperClass> mostviewedLocation = new ArrayList<>();
        mostviewedLocation.add(new MostViewedHelperClass(R.drawable.mcd,"Shoppers","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        mostviewedLocation.add(new MostViewedHelperClass(R.drawable.mcd,"Shoppers","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        mostviewedLocation.add(new MostViewedHelperClass(R.drawable.mcd,"Shoppers","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        adt= new MostViewedAdapter(mostviewedLocation);
        mostviewedRecycler.setAdapter(adt);
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

    public void openDrawer(View view) {

    }
}