package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class manabh1 extends AppCompatActivity {
    ListView list;
    List<String> i;
    ArrayAdapter<String> a;
    ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manabh1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        list= (ListView) findViewById(R.id.list);
        imgback= (ImageView) findViewById(R.id.imgback);
        listData();
        showData();
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(manabh1.this,navagation1.class);
                startActivity(i);
            }
        });
    }



    private void showData() {
        a=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,i);
        list.setAdapter(a);

    }

    private void listData() {

        i=new ArrayList<>();
        i.add("درگاه فهرست ملی ایران");
        i.add("دانشنامه ی تاریخ معماری ایران شهر");
        i.add("معماری یک دژ ایرانی");
        i.add("ایسنا");
        i.add("دانشنامه بزرگ اسلامی");
        i.add("آژانس خبری عکس ایران");
        i.add("وب سایت معماری معاصر ایران");
        i.add("موزه هنرهای معاصر");
        i.add("موزه هنرهای تزئینی");
        i.add("سیری در ایران");
        i.add("خبر گذاری میراث فرهنگی");
        i.add("وبسایت حرف روز");
        i.add("باشگاه خبرنگاران");
        i.add("روزنامه کیهان _ خبر فارسی");
        i.add("پایگاه خبری میراث فرهنگی ایران بزرگ.");
        i.add("هفته نامه تجارت");
        i.add("خبرگزاری مهر");
        i.add("اطلس گیتاشناسی استان های ایران");
        i.add("سازمان محیط زیست و فضای سبز و پارک های استان ها");
        i.add("نشریه الکترونیکی شرقیان");
        i.add("واحد مرکزی خبر جمهوری اسلامی");
        i.add("روزنامه ابتکار");
        i.add("خبرگذاری کتاب ایران");
        i.add("روزنامه ابتکار");
        i.add("روزنامه ابتکار");
        i.add("روزنامه ابتکار");

    }
}
