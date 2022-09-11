package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class kermanshah_hotel extends AppCompatActivity {
    RecyclerView recyclerview;
    List<datamodel_ker> mlist;
    myadapter_ker adapter;
    ImageView imgback;
    BottomNavigationView bnav;
    EditText etxt1;
    ImageView map;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kermanshah_hotel);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerview= (RecyclerView) findViewById(R.id.recycler);
        imgback= (ImageView) findViewById(R.id.imgback);
        bnav= (BottomNavigationView) findViewById(R.id.bnav);
        bnav.setSelectedItemId(R.id.hotel);

        preoareData();
        showdata();
        etxt1= (EditText) findViewById(R.id.etxt1);
        map= (ImageView) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(kermanshah_hotel.this,MapsActivity.class);
                startActivity(s);
            }
        });
        etxt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter_mlist(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.hotel:
                        return true;

                    case R.id.jazebh:
                        startActivity(new Intent(getApplicationContext(), kermanshah.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.resturan:
                        startActivity(new Intent(getApplicationContext(),kermanshah_restoran.class));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.kharid:
                        startActivity(new Intent(getApplicationContext(), kermanshah_bazar.class));
                        overridePendingTransition(0,0);
                        return true;




                }



                return true;
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(kermanshah_hotel.this,start.class);
                startActivity(i);
            }
        });

    }

    private void showdata() {
        adapter=new myadapter_ker(mlist,kermanshah_hotel.this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(adapter);
    }

    private void preoareData() {
        if (mlist == null) {
            mlist = new ArrayList<>();
        } else {
            mlist.clear();
        }


        mlist.add(new datamodel_ker("هتل پارسیان","هتل 5 ستاره", getResources().getString(R.string.parsyin),R.drawable.h3, "ایران - کرمانشاه", "کرمانشاه - بلوار شهید کشوری - جنب پارک ولایت", "083-34219162", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","0"));
        mlist.add(new datamodel_ker("هتل لاله بیستون","هتل 5 ستاره",getResources().getString(R.string.lalh),R.drawable.h5, "ایران - کرمانشاه", "37 کیلومتر از کرمانشاه و 2 کیلومتر تا شهر بیستون -کاروانسرای عباسی", "0833-82214555",R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","1"));
        mlist.add(new datamodel_ker("هتل جمشید","هتل 4 ستاره",getResources().getString(R.string.jamshid),R.drawable.h1, "ایران - کرمانشاه", "کرمانشاه میدان طاقبستان", "083-34296002", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","2"));
        mlist.add(new datamodel_ker("هتل آپارتمان کورش","هتل 3 ستاره",getResources().getString(R.string.korosh),R.drawable.h4, "ایران - کرمانشاه", "کرمانشاه - 22 بهمن - بلوار گلریزان", "083-38390417", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","3"));
        mlist.add(new datamodel_ker("هتل سینا","هتل 2 ستاره",getResources().getString(R.string.sina),R.drawable.h6, "ایران - کرمانشاه","کرمانشاه - سرچشمه - بلوار جمهوری اسلامی", "083-37295815", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","4"));
        mlist.add(new datamodel_ker("هتل آپارتمان پاتاق","هتل 5 ستاره",getResources().getString(R.string.patagh),R.drawable.h9, "ایران - کرمانشاه", "کرمانشاه - 22 بهمن بلوار آل آقا کوی 203", "083-38397110", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","5"));
        mlist.add(new datamodel_ker("اقامتگاه عمارت بامگاه ","هتل 4 ستاره",getResources().getString(R.string.bamgah),R.drawable.h10, "ایران - کرمانشاه", "کرمانشاه - خیابان مدرس روبرو مسجد جامع کوچه انتظاری", "083-37213794", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h1,"0","6"));
        mlist.add(new datamodel_ker("هتل آزادگان","هتل 4 ستاره",getResources().getString(R.string.azadegan),R.drawable.h2, "ایران - کرمانشاه", "کرمانشاه - شهرک تعاون", "083-34225591", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","7"));
        mlist.add(new datamodel_ker("هتل رسالت","هتل 3 ستاره",getResources().getString(R.string.resalat),R.drawable.h7, "ایران - کرمانشاه", "کرمانشاه - میدان فردوسی - ابتدای خیابان کسری", "083-37246365", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","8"));
        mlist.add(new datamodel_ker("هتل راه کربلا","هتل 2 ستاره",getResources().getString(R.string.karbali),R.drawable.h10, "ایران - کرمانشاه", "کرمانشاه - خیابان مدرس - خیابان پارکینگ شهرداری", "083-37273665", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","9"));
        mlist.add(new datamodel_ker("هتل پارسیان","هتل 5 ستاره", getResources().getString(R.string.parsyin),R.drawable.h3, "ایران - کرمانشاه", "کرمانشاه - بلوار شهید کشوری - جنب پارک ولایت", "083-34219162", R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","10"));
        mlist.add(new datamodel_ker("هتل لاله بیستون","هتل 5 ستاره",getResources().getString(R.string.lalh),R.drawable.h5, "ایران - کرمانشاه", "37 کیلومتر از کرمانشاه و 2 کیلومتر تا شهر بیستون -کاروانسرای عباسی", "0833-82214555",R.drawable.h1,R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,"0","11"));

    }
}
