package com.starixc.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
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

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //variables
    static  final float END_SCALE =0.7f;

    RecyclerView featureRecycler, mostviewedRecycler, catRecycler;
    RecyclerView.Adapter adapter, adt, catAdt;
    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //icon menu
    ImageView menuIcon;
    LinearLayout contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //hooks
        contentView = findViewById(R.id.contentView);
        featureRecycler = findViewById(R.id.featuredRecycler);
        mostviewedRecycler = findViewById(R.id.mostviewedRecycler);
        catRecycler = findViewById(R.id.catRecycler);
//        menu hooks
        drawerLayout = findViewById(R.id.drawer_lt);
        navigationView = findViewById(R.id.drawer_menu);
        menuIcon = findViewById(R.id.menu_icon);

        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        featuredRecycler();
        mostviewedRecycler();
        catRecycler();
        openDrawer();
    }


    private void catRecycler() {
        catRecycler.setHasFixedSize(true);
        catRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CategoryHelperClass> categoryList = new ArrayList<>();
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img, "Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img, "Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img, "Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img, "Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img, "Restaurant"));
        categoryList.add(new CategoryHelperClass(R.drawable.restaurant_img, "Restaurant"));
        catAdt = new CategoryAdapter(categoryList);
        catRecycler.setAdapter(catAdt);
    }

    private void mostviewedRecycler() {
        mostviewedRecycler.setHasFixedSize(true);
        mostviewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostviewedLocation = new ArrayList<>();
        mostviewedLocation.add(new MostViewedHelperClass(R.drawable.mcd, "Shoppers", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        mostviewedLocation.add(new MostViewedHelperClass(R.drawable.mcd, "Shoppers", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        mostviewedLocation.add(new MostViewedHelperClass(R.drawable.mcd, "Shoppers", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        adt = new MostViewedAdapter(mostviewedLocation);
        mostviewedRecycler.setAdapter(adt);
    }

    private void featuredRecycler() {
        featureRecycler.setHasFixedSize(true);
        //change liner layout from horizontal to vertical
        featureRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHealperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHealperClass(R.drawable.mcd, "Mcdonald's", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        featuredLocations.add(new FeaturedHealperClass(R.drawable.mcd, "Number 2", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        featuredLocations.add(new FeaturedHealperClass(R.drawable.mcd, "number 3", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"));
        adapter = new FeaturedAdapter(featuredLocations);
        featureRecycler.setAdapter(adapter);

    }
//Navigation Drawer Functions
    private void openDrawer() {
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
       drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
           @Override
           public void onDrawerSlide(View drawerView, float slideOffset) {

               //scale the view based on currebt slide offset
               final float diffScaledOffset = slideOffset* (1-END_SCALE);
               final float offsetScale = 1-diffScaledOffset;

               contentView.setScaleX(offsetScale);
               contentView.setScaleY(offsetScale);

               //transale the view, accounting for the scaled widt
               final float xOffset = drawerView.getWidth()*slideOffset;
               final float xOffsetDiff = contentView.getWidth()*diffScaledOffset;
               final  float xTranslation = xOffset-xOffsetDiff;
               contentView.setTranslationX(xTranslation);


           }
       });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }
}