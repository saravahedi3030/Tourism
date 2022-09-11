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

public class kermanshah extends AppCompatActivity {
    RecyclerView recyclerview;
    List<datamodel> mlist;
    myadapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ImageView imgback;
    BottomNavigationView bnav;
    EditText etxt1;
    ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kermanshah);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imgback = (ImageView) findViewById(R.id.imgback);
        recyclerview = (RecyclerView) findViewById(R.id.recycler);
        preoareData();
        showdata();

        bnav = (BottomNavigationView) findViewById(R.id.bnav);
        bnav.setSelectedItemId(R.id.jazebh);

        etxt1 = (EditText) findViewById(R.id.etxt1);
        map = (ImageView) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(kermanshah.this, MapsActivity.class);
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
                    case R.id.jazebh:
                        return true;


                    case R.id.resturan:
                        startActivity(new Intent(getApplicationContext(), kermanshah_restoran.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.kharid:
                        startActivity(new Intent(getApplicationContext(), kermanshah_bazar.class));
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
                Intent i = new Intent(kermanshah.this, start.class);
                startActivity(i);
            }
        });

    }


    private void showdata() {
        adapter = new myadapter(mlist, kermanshah.this);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapter);
    }

    private void preoareData() {
        if (mlist == null) {
            mlist = new ArrayList<>();
        } else {
            mlist.clear();
        }


        mlist.add(new datamodel("طاقبستان", getResources().getString(R.string.tagbostan), R.drawable.k1, "ایران - کرمانشاه", "کرمانشاه - طاق بستان - میدان طاق بستان - طاق بستان", "083-34218891",  R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("بیستون",getResources().getString(R.string.biston),R.drawable.biston1,"ایران - کرمانشاه","کرمانشاه - بزرگراه همدان - کرمانشاه ","083-45883814", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("تکیه معاون الملک",getResources().getString(R.string.tekyh),R.drawable.k3,"ایران - کرمانشاه","کرمانشاه - محله آبشوران قدیم - خیابان شهید حداد عادل","083-37214757", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("تکیه بیگلربیگی",getResources().getString(R.string.beglar),R.drawable.k4,"ایران - کرمانشاه","کرمانشاه - خیابان مدرس - مقابل مسجد جامع","0833-37286579", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("پارک کوهستان",getResources().getString(R.string.parkkohestan),R.drawable.k5,"ایران - کرمانشاه","کرمانشاه - بلوار شیرودی - بعد از طاق بستان -میدان کوهنورد - پارک کوهستان","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("غار پراو",getResources().getString(R.string.garpariv),R.drawable.k6,"ایران - کرمانشاه","کرمانشاه 12 کیلومتری شمال شرق شهر کرمانشاه میان کوه های طاق بستان و بیستون","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("سراب نیلوفر",getResources().getString(R.string.saribnelofa),R.drawable.k7,"ایران - کرمانشاه","کرمانشاه - 20 کیلومتری شمال غرب کرمانشاه به سمت کوزران ","0831-2262919", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("تالاب هشیلان",getResources().getString(R.string.talabheshelan),R.drawable.k8,"ایران - کرمانشاه","کرمانشاه - 26 کیومتری شمال غرب کرمانشاه - دهستان الهیار خانی","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("موزه پوشاک و زیورآلات",getResources().getString(R.string.mozeh),R.drawable.k9,"ایران - کرمانشاه","کرمانشاه - محله آبشوران قدیم - خیابان شهید حداد عادل - تکیه معاون الملک","083-37214757", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("موزه مردم شناسی",getResources().getString(R.string.mozehmardom),R.drawable.k10,"ایران - کرمانشاه","کرمانشاه - محله آبشوران قدیم - خیابان شهید حداد عادل - تکیه معاون الملک","083-37214757", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("باغ گلها",getResources().getString(R.string.kangavar),R.drawable.k11,"ایران - کرمانشاه","کرمانشاه - کمربندی غربی - روبروی ترمینال راه کربلا","083-37214747", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("گوردخمه ها", getResources().getString(R.string.gordkhanh), R.drawable.gordkhanh, "ایران - کرمانشاه", "کرمانشاه - 25 کیلومتری جنوب غربی شهرستان هرسین شمال شرق روستای ده نو", "083-48232835",  R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("غار قوری قلعه",getResources().getString(R.string.ghorighalh),R.drawable.ghorighalh,"ایران - کرمانشاه","کرمانشاه - مسیر جاده پاوه شمال شهر جوانرود ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("پاوه",getResources().getString(R.string.pavh),R.drawable.pavh,"ایران - کرمانشاه","کرمانشاه - میدان  امام حسین به سمت کامیاران","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("سراب صحنه",getResources().getString(R.string.sarabsahnh),R.drawable.sarabsahnh,"ایران - کرمانشاه","کرمانشاه - 55 کیلومتری شهر کرمانشاه - شهرستان صحنه ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("مسجد شافعی",getResources().getString(R.string.masjdshafi),R.drawable.masjdshafi,"ایران - کرمانشاه","کرمانشاه - میدان جوانشیر (میدان توپخانه سابق) - مسجد شافعی","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("غار دواشکفت",getResources().getString(R.string.ghardo),R.drawable.ghardo,"ایران - کرمانشاه","کرمانشاه - قسمت شمالی شهر کرمانشاه دامنه کوه میوله نزدیک طاقبستان ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("طاق گرا",getResources().getString(R.string.taghgra),R.drawable.taghgra,"ایران - کرمانشاه","کرمانشاه - 15 کیلومتری شهرستان سرپل ذهاب - گردنه پاتاق","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("نخلستان قصر",getResources().getString(R.string.nakhlstan),R.drawable.nakhlstan,"ایران - کرمانشاه","کرمانشاه - گیلانغرب ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("سفید برگ",getResources().getString(R.string.sefidbaegh),R.drawable.sefidbaegh,"ایران - کرمانشاه","کرمانشاه - 18 کیلومتری شهرستان جوانرود ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("دالاهو",getResources().getString(R.string.dalaho),R.drawable.dalaho,"ایران - کرمانشاه","کرمانشاه - 99 کیلومتری غرب کرمانشاه ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("ثلاث باباجانی",getResources().getString(R.string.salasbabajani),R.drawable.salasbabajani,"ایران - کرمانشاه","کرمانشاه - ثلاث باباجانی ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("کنگاور",getResources().getString(R.string.kangavar),R.drawable.kangavar,"ایران - کرمانشاه","کرمانشاه - کنگاور ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("آرامگاه اویس قرنی",getResources().getString(R.string.aramgahoves),R.drawable.aramgahoves,"ایران - کرمانشاه","کرمانشاه - روانسر - ارتفاعات بیشه کوه ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("کوه چال آباد",getResources().getString(R.string.kohchal),R.drawable.kohchal,"ایران - کرمانشاه","کرمانشاه - روانسر - ارتفاعات بیشه کوه ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("کلیسای پنطی کاستی",getResources().getString(R.string.kelesa),R.drawable.kelesa,"ایران - کرمانشاه","کرمانشاه - خیابان شریعتی - کوچه آرین ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("شکارگاه خسروپرویز",getResources().getString(R.string.khosroparvis),R.drawable.khosroparvis,"ایران - کرمانشاه","کرمانشاه - شمال شهر کرمانشاه - پایین تر از طاقبستان ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("بقعه سرقبرآقا",getResources().getString(R.string.ghabragha),R.drawable.ghabragha,"ایران - کرمانشاه","کرمانشاه - خیابان آل آقا ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("سفید کوه",getResources().getString(R.string.sefidkoh),R.drawable.sefidkoh,"ایران - کرمانشاه","کرمانشاه - سفید کوه ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("کلیسای مقدس مسیح",getResources().getString(R.string.kelesaghalb),R.drawable.kelesaghalb,"ایران - کرمانشاه","کرمانشاه - خیابان مدرس - کوچه امیر مقدم ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("حمام حاج شهبازخان",getResources().getString(R.string.hamamhaj),R.drawable.hamamhaj,"ایران - کرمانشاه","کرمانشاه - بافت تاریخی - خیابان مدرس  ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));
        mlist.add(new datamodel("سراب قنبر",getResources().getString(R.string.sarabghanbar),R.drawable.sarabghanbar,"ایران - کرمانشاه","کرمانشاه - دامنه کوه سفید  ","ندارد", R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6, R.drawable.k7, R.drawable.k8, R.drawable.k9, R.drawable.k10));



    }
    }



