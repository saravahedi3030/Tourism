package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class jazbh_kol extends AppCompatActivity {
    RecyclerView recycler;
    List<datamodel_kol> mlist;
    myadapter_kol adapter;
    EditText etxt1;
    ImageView imgback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jazbh_kol);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recycler= (RecyclerView) findViewById(R.id.recycler);
        etxt1 = (EditText) findViewById(R.id.etxt1);
        imgback= (ImageView) findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(jazbh_kol.this,navagation1.class);
                startActivity(ii);
            }
        });
        preoareData();
        showdata();
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
    }
    private void showdata() {
        adapter=new myadapter_kol(mlist,jazbh_kol.this);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
    }

    private void preoareData() {
        if (mlist == null) {
            mlist = new ArrayList<>();
        } else {
            mlist.clear();
        }


        mlist.add(new datamodel_kol("تهران","داراآباد", getResources().getString(R.string.tehran),R.drawable.daraabad ));
        mlist.add(new datamodel_kol("تبریز","ارگ علیشاه", getResources().getString(R.string.alishah),R.drawable.alishah ));
        mlist.add(new datamodel_kol("مازندران","پل ورسک", getResources().getString(R.string.mazandaran),R.drawable.pol ));
        mlist.add(new datamodel_kol("اردبیل","دریاچه شورابیل", getResources().getString(R.string.ardbil),R.drawable.darya ));
        mlist.add(new datamodel_kol("کهگیلویه و بویر احمد","دریاچه برم الوان", getResources().getString(R.string.kahkyoler),R.drawable.alvan ));
        mlist.add(new datamodel_kol("لرستان","دره خزینه", getResources().getString(R.string.khazenh),R.drawable.khazenh ));

    }
}
