package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class rahnama extends AppCompatActivity {

    ImageView imgback,img1;
    TextView txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rahnama);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        imgback= (ImageView) findViewById(R.id.imgback);
        img1= (ImageView) findViewById(R.id.img1);
        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(rahnama.this,safar_kermanshah.class);
                startActivity(a);
            }
        });
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(rahnama.this,safar_kermanshah.class);
                startActivity(b);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c=new Intent(rahnama.this,safar_kermanshah.class);
                startActivity(c);
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(rahnama.this,navagation1.class);
                startActivity(i);
            }
        });
    }
}
