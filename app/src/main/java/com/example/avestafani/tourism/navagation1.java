package com.example.avestafani.tourism;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class navagation1 extends AppCompatActivity {
    DrawerLayout ml;
    Toolbar toolbar;
    ImageButton air,map,rah,home;
    NavigationView nav_menu;
    ViewPager viewPager1;
    LinearLayout layoutdots1;
    int[]layouts={R.layout.slid1,R.layout.slid2,R.layout.slid3,R.layout.slid4};
    private Timer timer;
    private int current_position=0;
    List<Integer> imageList=new ArrayList<>();
    ImageView location,im1,img2,im4,img3,img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navagation1);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        air= (ImageButton) findViewById(R.id.air);
        map= (ImageButton) findViewById(R.id.map);
        rah= (ImageButton) findViewById(R.id.rah);
        home= (ImageButton) findViewById(R.id.home);
        CardView card1= (CardView) findViewById(R.id.card1);
        CardView card2= (CardView) findViewById(R.id.card2);
        CardView card3= (CardView) findViewById(R.id.card3);
        CardView card4= (CardView) findViewById(R.id.card4);
        im1= (ImageView) findViewById(R.id.im1);
        img2=(ImageView) findViewById(R.id.img2);
        im4=(ImageView) findViewById(R.id.im4);
        img3=(ImageView) findViewById(R.id.img3);
        img1=(ImageView) findViewById(R.id.img1);

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dr=new Intent(navagation1.this,ertebat1_activity.class);
                startActivity(dr);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lk=new Intent(navagation1.this,rahnama.class);
                startActivity(lk);
            }
        });
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pq=new Intent(navagation1.this,show_safar.class);
                startActivity(pq);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kj=new Intent(navagation1.this,jazbh_kol.class);
                startActivity(kj);
            }
        });


        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        card1.startAnimation(a);

        Animation b = AnimationUtils.loadAnimation(this, R.anim.fadein);
        card2.startAnimation(b);

        Animation c = AnimationUtils.loadAnimation(this, R.anim.fadein);
        card3.startAnimation(c);

        Animation s = AnimationUtils.loadAnimation(this, R.anim.fadein);

        card4.startAnimation(s);

        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ff=new Intent(navagation1.this,show_safar.class);
                startActivity(ff);
            }
        });

        rah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xq=new Intent(navagation1.this,rahnama.class);
                startActivity(xq);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sd=new Intent(navagation1.this,MapsActivity.class);
                startActivity(sd);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa=new Intent(navagation1.this,start.class);
                startActivity(aa);
            }
        });











        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_navigation);
        nav_menu = (NavigationView) findViewById(R.id.nav_menu);
        ml = (DrawerLayout) findViewById(R.id.ml);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(navagation1.this, ml, toolbar, R.string.open_draw, R.string.close_draw);
        ml.addDrawerListener(toggle);
        viewPager1= (ViewPager) findViewById(R.id.viewpager1);
        layoutdots1= (LinearLayout) findViewById(R.id.layoutdots1);
        imageList.add(R.drawable.aa);
        imageList.add(R.drawable.bb);
        imageList.add(R.drawable.cc);
        imageList.add(R.drawable.dd);
        showdots(viewPager1.getCurrentItem());
        myadapter_slider myadapter_slider=new myadapter_slider(imageList);
        viewPager1.setAdapter(myadapter_slider);
        createslideshow();
        location= (ImageView) findViewById(R.id.location);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(navagation1.this,MapsActivity.class);
                startActivity(ii);
            }
        });

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
                       Intent z=new Intent(navagation1.this,start.class);
                       startActivity(z);
                       break;


                   case R.id.rahnama:
                       Intent x=new Intent(navagation1.this,rahnama.class);
                       startActivity(x);
                       break;

                   case R.id.moarfi:
                       Intent g=new Intent(navagation1.this,moarfi.class);
                       startActivity(g);
                       break;



                   case R.id.manabh:
                       Intent k=new Intent(navagation1.this,manabh1.class);
                       startActivity(k);
                       break;



                   case R.id.ertebat:
                       Intent l=new Intent(navagation1.this,ertebat1_activity.class);
                       startActivity(l);
                       break;





                   case R.id.safar:
                       Intent f=new Intent(navagation1.this,show_safar.class);
                       startActivity(f);
                       break;


                   case R.id.sheare:
                       Intent intent=new Intent(Intent.ACTION_SEND);
                       intent.setType("text/plain");
                       String Body="Download this App";
                       String Sub="http://play.google.com";
                       intent.putExtra(Intent.EXTRA_TEXT,Body);
                       intent.putExtra(Intent.EXTRA_TEXT,Sub);
                       startActivity(Intent.createChooser(intent,"share using"));
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



    private void showdots(int pagenumber) {
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
