package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class show_jazbh_kol extends AppCompatActivity {
    TextView txt1,txt2,txt3;
    ImageView img1,imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jazbh_kol);
        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        txt3= (TextView) findViewById(R.id.txt3);
        img1= (ImageView) findViewById(R.id.img1);
        imgback= (ImageView) findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(show_jazbh_kol.this,jazbh_kol.class);
                startActivity(i);
            }
        });


        Intent i=getIntent();
        String name=i.getStringExtra("name1");
        String name1=i.getStringExtra("name2");
        String name2=i.getStringExtra("name3");
        int image=i.getIntExtra("image",0);
        txt1.setText(name);
        txt2.setText(name1);
        txt3.setText(name2);
        img1.setImageResource(image);
    }
}
