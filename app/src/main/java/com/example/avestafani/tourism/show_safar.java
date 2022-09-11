package com.example.avestafani.tourism;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class show_safar extends AppCompatActivity implements View.OnLongClickListener {
    boolean is_in_action_mode=false;
    TextView tcounter;
    dbhelper1 db16;
    int count=0;
    RecyclerView recycler1;
    ArrayList<mymodel2> data;
    ArrayList<mymodel2>select;
    private myadapter2 myadapter2;
    EditText search;
    Toolbar toolbar;
    BottomNavigationView bnav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_safar);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        search= (EditText) findViewById(R.id.search);
        db16 = new dbhelper1(this);
        data=new ArrayList<>();
        select = new ArrayList<>();
        bnav = (BottomNavigationView) findViewById(R.id.bnav);
        bnav.setSelectedItemId(R.id.add);

        recycler1 = (RecyclerView) findViewById(R.id.recycler);
        display();
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tcounter = (TextView) findViewById(R.id.tcounter);
        tcounter.setVisibility(View.GONE);

        bnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add:
                        startActivity(new Intent(getApplicationContext(), safar_my.class));
                        overridePendingTransition(0,0);
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

                    case R.id.jazebh:
                        startActivity(new Intent(getApplicationContext(), kermanshah.class));
                        overridePendingTransition(0,0);
                        return true;

                }


                return true;
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myadapter2.filter1(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void display() {
        data = new ArrayList<>();
        Cursor cursor = db16.getData1();
        if (cursor.getCount() == 0) {
            return;
        } else {
            while (cursor.moveToNext()) {
                String name1 = cursor.getString(1);
                byte[] img = cursor.getBlob(2);
                Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                String loc = cursor.getString(3);
                String date1 = cursor.getString(4);
                String fri = cursor.getString(5);
                data.add(new mymodel2(name1, bitmap, loc, date1, fri));
            }
        }
        myadapter2 = new myadapter2(data,show_safar.this);
        recycler1.setLayoutManager(new LinearLayoutManager(this));
        recycler1.setAdapter(myadapter2);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
    }

    @Override
    public boolean onLongClick(View v) {


        if (!is_in_action_mode){
            is_in_action_mode=true;
        }
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_action_mode);
        tcounter.setVisibility(View.VISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myadapter2.notifyDataSetChanged();

        return true;
    }


    public void selection(View view,int postion){
        if (((CheckBox)view).isChecked()){
            select.add(data.get(postion));
            count=count+1;
            update(count);
        }
        else {
            select.remove(data.get(postion));
            count=count-1;
            update(count);
        }
    }

    public void update(int count){
        if (count==0){
            tcounter.setText("0");
        }
        else {
            tcounter.setText(count+"");
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.item_delete){
            clearactionmode();
            if (item.getItemId()==R.id.item_delete){
                for(mymodel2 s:select){
                    data.remove(s);
                    myadapter2 = new myadapter2(data,show_safar.this);
                    db16.deletedata(s.getName().toString());
                    recycler1.setAdapter(myadapter2);
                    myadapter2.notifyDataSetChanged();
                }
            }
        }else if (item.getItemId()==R.id.item_share){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String Body="Download this App";
            String Sub="http://play.google.com";
            intent.putExtra(Intent.EXTRA_TEXT,Body);
            intent.putExtra(Intent.EXTRA_TEXT,Sub);
            startActivity(Intent.createChooser(intent,"share using"));
        }
        else if (item.getItemId()==android.R.id.home){
            clearactionmode();
            myadapter2.notifyDataSetChanged();
        }
        return true;
    }
    public void clearactionmode(){
        is_in_action_mode=false;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        tcounter.setVisibility(View.GONE);
        tcounter.setText("0");
        count=0;

    }

    @Override
    public void onBackPressed() {
        if (is_in_action_mode){
            clearactionmode();
            myadapter2.notifyDataSetChanged();
        }
        else {
            super.onBackPressed();

        }
    }
}
