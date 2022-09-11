package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.avestafani.tourism.R.id.img2;

public class start extends AppCompatActivity {
LinearLayout line1,line2,line3,line4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        line1= (LinearLayout) findViewById(R.id.line1);
        line2= (LinearLayout) findViewById(R.id.line2);
        line3= (LinearLayout) findViewById(R.id.line3);
        line4= (LinearLayout) findViewById(R.id.line4);
        ImageView img3= (ImageView) findViewById(R.id.img3);


        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(start.this,kermanshah.class);
                startActivity(i1);
            }
        });







    }
}

