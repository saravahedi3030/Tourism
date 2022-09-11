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

public class kermanshah_bazar extends AppCompatActivity {
    RecyclerView recyclerview;
    List<datamodel_ker_bazar> mlist;
    myadapter_ker_bazar adapter;
    ImageView imgback;
    BottomNavigationView bnav;
    RecyclerView.LayoutManager layoutManager;
    EditText etxt1;
    ImageView map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kermanshah_bazar);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerview= (RecyclerView) findViewById(R.id.recycler);
        imgback= (ImageView) findViewById(R.id.imgback);
        preoareData();
        showdata();
        bnav= (BottomNavigationView) findViewById(R.id.bnav);
        bnav.setSelectedItemId(R.id.kharid);

        etxt1= (EditText) findViewById(R.id.etxt1);
        map= (ImageView) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(kermanshah_bazar.this,MapsActivity.class);
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
                    case R.id.kharid:
                        return true;

                    case R.id.jazebh:
                        startActivity(new Intent(getApplicationContext(), kermanshah.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.resturan:
                        startActivity(new Intent(getApplicationContext(),kermanshah_restoran.class));
                        overridePendingTransition(0,0);
                        return true;



                    case R.id.hotel:
                        startActivity(new Intent(getApplicationContext(), kermanshah_hotel.class));
                        overridePendingTransition(0,0);
                        return true;
                }


                return true;
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(kermanshah_bazar.this,start.class);
                startActivity(i);
            }
        });


    }

    private void showdata() {
        adapter=new myadapter_ker_bazar(mlist,kermanshah_bazar.this);
        layoutManager=new GridLayoutManager(this,3);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapter);
    }

    private void preoareData() {
        if (mlist == null) {
            mlist = new ArrayList<>();
        } else {
            mlist.clear();
        }



        mlist.add(new datamodel_ker_bazar("مرکز خرید لیلیوم",getResources().getString(R.string.pasaj_liliyom), R.drawable.b5, "ایران - کرمانشاه", "کرمانشاه - خیابان کسری", "083-37203743", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("بازار توپخانه", getResources().getString(R.string.bazar_topkhanh), R.drawable.b2, "ایران - کرمانشاه", "کرمانشاه - خیابان موید - بازار در طویله توپخانه", "ندارد",R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("بازار زرگرها اطلس", getResources().getString(R.string.bazar_zargarha), R.drawable.b9, "ایران - کرمانشاه", "کرمانشاه - خیابان مدرس  ", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("مرکز خرید گلستان", getResources().getString(R.string.pasaj_golestan), R.drawable.b11, "ایران - کرمانشاه", "کرمانشاه - بازار - بلوار مطهری خ مدرس", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("بازار روز کرمانشاه", getResources().getString(R.string.bazar_roz), R.drawable.b6, "ایران - کرمانشاه", "کرمانشاه - میدان آزادی - بلوار شهید بهشتی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("بازار برنجی", getResources().getString(R.string.bazar_berenje), R.drawable.b12, "ایران - کرمانشاه", "کرمانشاه - خیابان مدرس - بالاتر از مسجد جامع", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("بازار مسگرها", getResources().getString(R.string.bazar_mesgarha), R.drawable.b14, "ایران - کرمانشاه", "کرمانشاه - خ مدرس - بازار کلوچه پزها", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("جمعه بازار", getResources().getString(R.string.bazar_jome), R.drawable.b5, "ایران - کرمانشاه", "کرمانشاه - جاده قدیم تهران - پارک شرقی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("مرکز خرید نوبهار پلازا", getResources().getString(R.string.pasaj_pelaza), R.drawable.b1, "ایران - کرمانشاه", "کرمانشاه - خیابان 22 بهمن - چهارراه نوبهار", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("مرکز خرید ارگ", getResources().getString(R.string.pasaj_arg), R.drawable.b15, "ایران - کرمانشاه", "کرمانشاه - میدان مصدق", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ میر داماد", getResources().getString(R.string.pasaj_merdamad), R.drawable.b16, "ایران - کرمانشاه", "کرمانشاه - خیابان کاشانی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ کیش", getResources().getString(R.string.pasaj_kesh), R.drawable.b18, "ایران - کرمانشاه", "کرمانشاه - میدان آزادی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ سروش", getResources().getString(R.string.sorosh), R.drawable.sorosh, "ایران - کرمانشاه", "کرمانشاه - میدان آزادی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ آنجلس", getResources().getString(R.string.anjles), R.drawable.anjles, "ایران - کرمانشاه", "کرمانشاه - شهرک آبادانی و مسکن - بلوار گلها خیابان گلها", "09352488292", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("مرکزخریدالهیه", getResources().getString(R.string.elaheh), R.drawable.elahy, "ایران - کرمانشاه", "کرمانشاه - شهرک الهیه - خیابان کاشانی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ حافظ", getResources().getString(R.string.hafez), R.drawable.hafez, "ایران - کرمانشاه", "کرمانشاه - خیابان کاشانی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ ولیعصر", getResources().getString(R.string.valiasr), R.drawable.valeasr, "ایران - کرمانشاه", "کرمانشاه - خیابان کاشانی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ صدف", getResources().getString(R.string.sadaf), R.drawable.sadaf, "ایران - کرمانشاه", "کرمانشاه - خیابان معلم شرقی - خرداد", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ سریری", getResources().getString(R.string.sareri), R.drawable.moavn1, "ایران - کرمانشاه", "کرمانشاه - خیابان معلم", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("مرکزخریدمعاون الملک", getResources().getString(R.string.moaven), R.drawable.moavn, "ایران - کرمانشاه", "کرمانشاه - خیابان مدرس - خیابان شیخ مجتبی حاج آخوند", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("مرکزخریدعدالت", getResources().getString(R.string.edalat), R.drawable.edalat, "ایران - کرمانشاه", "کرمانشاه - خیابان معلم شرقی - تقاطع خیابان شریعتی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("مرکزخریدملت", getResources().getString(R.string.melat), R.drawable.melat, "ایران - کرمانشاه", "کرمانشاه - خانقاه - خیلبان اشرفی اصفهانی", "09187161076", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("مرکزخریدسینا", getResources().getString(R.string.sena), R.drawable.sina, "ایران - کرمانشاه", "کرمانشاه - خیابان مدرس - بین خیابان شیخ مجتبی حاج آخوند و بلوار شهید مطهری", "09188316895", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ هلال احمر", getResources().getString(R.string.helalahmar), R.drawable.helal, "ایران - کرمانشاه", "کرمانشاه - بلوار کارگر - بین بلوار شهید بهشتی و بلوار مصطفی امامی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));
        mlist.add(new datamodel_ker_bazar("پاساژ پردیس", getResources().getString(R.string.pardis1), R.drawable.pardes, "ایران - کرمانشاه", "کرمانشاه - خیابان اشرفی اصفهانی بین میدان مصدق و بابایی", "ندارد", R.drawable.b18,R.drawable.b17, R.drawable.b16, R.drawable.b15, R.drawable.b14, R.drawable.b13, R.drawable.b12, R.drawable.b11, R.drawable.b10, R.drawable.b9));



    }
}
