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

public class kermanshah_restoran extends AppCompatActivity {
    RecyclerView recyclerview;
    List<datamodel_ker_resturan> mlist;
    myadapter_ker_resturan adapter;
    ImageView imgback;
    BottomNavigationView bnav;
    EditText etxt1;
    ImageView map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kermanshah_restoran);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerview= (RecyclerView) findViewById(R.id.recycler);
        imgback= (ImageView) findViewById(R.id.imgback);
        bnav= (BottomNavigationView) findViewById(R.id.bnav);
        bnav.setSelectedItemId(R.id.resturan);

        preoareData();
        showdata();
        etxt1= (EditText) findViewById(R.id.etxt1);
        map= (ImageView) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(kermanshah_restoran.this,MapsActivity.class);
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
                    case R.id.resturan:
                        return true;

                    case R.id.jazebh:
                        startActivity(new Intent(getApplicationContext(), kermanshah.class));
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
                Intent i=new Intent(kermanshah_restoran.this,start.class);
                startActivity(i);
            }
        });

    }

    private void showdata() {
        adapter=new myadapter_ker_resturan(mlist,kermanshah_restoran.this);
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

        mlist.add(new datamodel_ker_resturan("رستوران ارگ",getResources().getString(R.string.resturan_arg), R.drawable.r, "ایران - کرمانشاه", "کرمانشاه - میدان کاشانی (مصدق ) طبقه یازدهم مجتمع تجاری و اداری ارگ", "083-37299410", R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران بامگاه عمارت", getResources().getString(R.string.emarat), R.drawable.r1, "ایران - کرمانشاه", "کرمانشاه - جلوخان روبروی مسجد جامع - کوچه انتظاری", "083-37213794",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران عالیجناب ", getResources().getString(R.string.resturan_alejenab), R.drawable.r2, "ایران - کرمانشاه","کرمانشاه - خیابان شریعتی - جنب بانک صادرات", "09187344005",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("باغ رستوران کامبادن", getResources().getString(R.string.resturan_kambadin), R.drawable.r10, "ایران - کرمانشاه", "کرمانشاه - پارک غربی - بریدگی دوم سمت راست", "09106183900",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران ئه شکه وت", getResources().getString(R.string.resturan_soni), R.drawable.r11, "ایران - کرمانشاه", "کرمانشاه - 25 کیلومتری شهر روانسر مجاور روستای قوری قلعه", "09189306447",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan(" رستوران هتل جمشید", getResources().getString(R.string.resturan_jamshid), R.drawable.r5, "ایران - کرمانشاه", "کرمانشاه - میدان طاق بستان", "083-34299666",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران اسلامی ", getResources().getString(R.string.resturan_eslami), R.drawable.r6, "ایران - کرمانشاه", "کرمانشاه - خیابان جوانشیر - کوچه لک ها", "083-38246902",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan(" رستوران شاندیز سرسبز", getResources().getString(R.string.resturan_shandez), R.drawable.r7, "ایران - کرمانشاه", "کرمانشاه - 100 کیلومتر بعد از میدان امام حسین به طرف کمربندی الهیه", "09181337030",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران دنده کباب حیدری", getResources().getString(R.string.resturan_hedari), R.drawable.r9, "ایران - کرمانشاه", "کرمانشاه - 9 کیلومتری کرمانشاه مجاور طاقبستان", "083-34277277",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران طربستان", getResources().getString(R.string.resturan_tarbastan), R.drawable.r14, "ایران - کرمانشاه", "کرمانشاه - بلوار شهید کشوری روبروی استانداری - هتل پارسیان", "083-34219174",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران شایلی", getResources().getString(R.string.resturan_shaeli), R.drawable.r17, "ایران - کرمانشاه", "کرمانشاه - میدان رفعتیه - انتهای خیابان پزشکان", "083-7263040",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران ارگ",getResources().getString(R.string.resturan_arg), R.drawable.r, "ایران - کرمانشاه", "کرمانشاه - میدان کاشانی (مصدق ) طبقه یازدهم مجتمع تجاری و اداری ارگ", "083-37299410", R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران بامگاه عمارت", getResources().getString(R.string.emarat), R.drawable.r1, "ایران - کرمانشاه", "کرمانشاه - جلوخان روبروی مسجد جامع - کوچه انتظاری", "083-37213794",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران عالیجناب ", getResources().getString(R.string.resturan_alejenab), R.drawable.r2, "ایران - کرمانشاه","کرمانشاه - خیابان شریعتی - جنب بانک صادرات", "09187344005",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("باغ رستوران کامبادن", getResources().getString(R.string.resturan_kambadin), R.drawable.r10, "ایران - کرمانشاه", "کرمانشاه - پارک غربی - بریدگی دوم سمت راست", "09106183900",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران ئه شکه وت", getResources().getString(R.string.resturan_soni), R.drawable.r11, "ایران - کرمانشاه", "کرمانشاه - 25 کیلومتری شهر روانسر مجاور روستای قوری قلعه", "09189306447",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan(" رستوران هتل جمشید", getResources().getString(R.string.resturan_jamshid), R.drawable.r5, "ایران - کرمانشاه", "کرمانشاه - میدان طاق بستان", "083-34299666",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران اسلامی ", getResources().getString(R.string.resturan_eslami), R.drawable.r6, "ایران - کرمانشاه", "کرمانشاه - خیابان جوانشیر - کوچه لک ها", "083-38246902",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan(" رستوران شاندیز سرسبز", getResources().getString(R.string.resturan_shandez), R.drawable.r7, "ایران - کرمانشاه", "کرمانشاه - 100 کیلومتر بعد از میدان امام حسین به طرف کمربندی الهیه", "09181337030",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران دنده کباب حیدری", getResources().getString(R.string.resturan_hedari), R.drawable.r9, "ایران - کرمانشاه", "کرمانشاه - 9 کیلومتری کرمانشاه مجاور طاقبستان", "083-34277277",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران طربستان", getResources().getString(R.string.resturan_tarbastan), R.drawable.r14, "ایران - کرمانشاه", "کرمانشاه - بلوار شهید کشوری روبروی استانداری - هتل پارسیان", "083-34219174",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران شایلی", getResources().getString(R.string.resturan_shaeli), R.drawable.r17, "ایران - کرمانشاه", "کرمانشاه - میدان رفعتیه - انتهای خیابان پزشکان", "083-7263040",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران سوری", getResources().getString(R.string.resturan_sori), R.drawable.sori, "ایران - کرمانشاه", "کرمانشاه - خیابان گمرک - جنب سربازخانه شهری - کوچه فصیحی پلاک127", "09358571557",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران سه کاج", getResources().getString(R.string.resturan_kaj), R.drawable.kaj, "ایران - کرمانشاه", "کرمانشاه - طاقبستان - جنب شهر شادی(داخل محوطه) ", "09188562899",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));
        mlist.add(new datamodel_ker_resturan("رستوران معتمد", getResources().getString(R.string.resturan_motamed), R.drawable.motamed, "ایران - کرمانشاه", "کرمانشاه - 22 بهمن سی متری دوم نبش چهارراه چاله چاله  ", "083-36388329",  R.drawable.r1,R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10));


    }
    }

