package com.example.costmizeddrawaer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    RelativeLayout viewPagerContainer;
    ViewPager viewPager;
    LinearLayout viewPagerDots;
    ViewPagerAdap viewPagerAdapter;
    List<ViewPagerModel> viewPagerModelList = new ArrayList<>();
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        setUpToolBar();

        initialize();

        setUpDrawer();

        prepareViewPagerArray();

        setUpViewPagerAdapter();



    }

    private void setUpViewPagerAdapter() {
        viewPagerAdapter = new ViewPagerAdap(this, viewPagerModelList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        addBottomDots(viewPagerDots, viewPagerAdapter.getCount(), 0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                ((TextView) findViewById(R.id.title1)).setText(viewPagerModelList.get(position).getPageName());
                addBottomDots(viewPagerDots, viewPagerAdapter.getCount(), position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    private void prepareViewPagerArray() {
        ViewPagerModel firstPage = new ViewPagerModel("FirstPage", 0,R.drawable.img1);
        viewPagerModelList.add(firstPage);

        ViewPagerModel secondPage = new ViewPagerModel("secondPage", 1,R.drawable.img2);
        viewPagerModelList.add(secondPage);

        ViewPagerModel ThirdPage = new ViewPagerModel("ThirdPage", 1,R.drawable.img3);
        viewPagerModelList.add(ThirdPage);

    }

    @SuppressLint("RestrictedApi")
    private void setUpDrawer() {
        Objects.requireNonNull(getSupportActionBar()).setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void initialize() {
        collapsingToolbarLayout = findViewById(R.id.collapsToolbarLayout);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        viewPager= findViewById(R.id.viewpager);
        viewPagerDots=findViewById(R.id.view_pager_dots);
    }

    private void setUpToolBar() {

        collapsingToolbarLayout.setCollapsedTitleGravity(View.TEXT_ALIGNMENT_CENTER);
        collapsingToolbarLayout.setExpandedTitleColor(Color.argb(0, 0, 0, 0));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.profile:
                Toast.makeText(MainActivity.this, "Profile Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Toast.makeText(MainActivity.this, "Contact us Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(MainActivity.this, "About us Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(MainActivity.this, "Logout Selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }
    private void addBottomDots(LinearLayout viewPagerDots, int size, int current) {
        ImageView[] dots = new ImageView[size];
        viewPagerDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(15, 15, 30, 15);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.tab_indicator_default);
            viewPagerDots.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[current].setImageResource(R.drawable.tab_indicator_selected);
        }
    }

}
