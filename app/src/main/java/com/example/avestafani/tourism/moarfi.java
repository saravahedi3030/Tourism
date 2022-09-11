package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class moarfi extends AppCompatActivity {
    ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moarfi);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imgback= (ImageView) findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(moarfi.this,navagation1.class);
                startActivity(i);
            }
        });
    }
}
