package com.example.avestafani.tourism;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class navigation extends AppCompatActivity {
    DrawerLayout ml;
    Toolbar toolbar_nav;
    NavigationView nav_menu;
    ViewPager viewPager1;
    LinearLayout layoutdots1;
    int[]layouts={R.layout.slid1,R.layout.slid2,R.layout.slid3,R.layout.slid4};
    private Timer timer;
    private int current_position=0;
    List<Integer> imageList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        toolbar_nav = (Toolbar) findViewById(R.id.toolbar_nav);
        setSupportActionBar(toolbar_nav);
        nav_menu = (NavigationView) findViewById(R.id.nav_menu);
        ml = (DrawerLayout) findViewById(R.id.ml);
        ml = (DrawerLayout) findViewById(R.id.ml);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(navigation.this, ml, toolbar_nav, R.string.open_draw, R.string.close_draw);
        ml.addDrawerListener(toggle);

        viewPager1= (ViewPager) findViewById(R.id.viewpager1);
        layoutdots1= (LinearLayout) findViewById(R.id.layoutdots1);
        imageList.add(R.drawable.im1);
        imageList.add(R.drawable.im1);
        imageList.add(R.drawable.im1);
        imageList.add(R.drawable.im1);
        showdots(viewPager1.getCurrentItem());
        myadapter_slider myadapter_slider=new myadapter_slider(imageList);
        viewPager1.setAdapter(myadapter_slider);
        createslideshow();
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                showdots(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        nav_menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.shahr:
                        Intent z=new Intent(navigation.this,start.class);
                        startActivity(z);
                        break;


                    case R.id.rahnama:
                        Intent x=new Intent(navigation.this,start.class);
                        startActivity(x);
                        break;

                    case R.id.moarfi:
                        Intent g=new Intent(navigation.this,start.class);
                        startActivity(g);
                        break;
                }
                return true;
            }
        });


    }

    private void createslideshow() {
        final Handler handler = new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if (current_position==imageList.size())
                    current_position=0;
                viewPager1.setCurrentItem(current_position++,true);

            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);

            }
        },250,2500);
    }


    private void showdots(int pagenumber ) {
        TextView[]dots=new TextView[layouts.length];
        layoutdots1.removeAllViews();
        for (int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
            dots[i].setTextColor(ContextCompat.getColor(this,i==pagenumber?R.color.colorAccent:R.color.colorPrimary));
            layoutdots1.addView(dots[i]);
        }

    }

    @Override
    public void onBackPressed() {
        if (ml.isDrawerOpen(GravityCompat.START)){
            ml.closeDrawer(GravityCompat.START);
        }else {

            super.onBackPressed();
        }
    }
}
