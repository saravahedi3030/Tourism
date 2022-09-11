package com.example.avestafani.tourism;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class log_in extends AppCompatActivity implements View.OnClickListener {
    TextView t1;
    EditText txtname,txtpass;
    dbhelper db1;
    TextView txt3,txt20;
    ImageView im1;
    FloatingActionButton google,insta;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        b= (Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sd=new Intent(log_in.this,navagation1.class);
                startActivity(sd);
            }
        });
        google= (FloatingActionButton) findViewById(R.id.google);
        insta= (FloatingActionButton) findViewById(R.id.insta);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golink("https://www.google.com");

            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golink("https://www.instagram.com");

            }
        });
        Animation x = AnimationUtils.loadAnimation(this, R.anim.fadein);
        google.startAnimation(x);

        Animation xx = AnimationUtils.loadAnimation(this, R.anim.fadein);
        insta.startAnimation(xx);

        db1 = new dbhelper(this);
        t1= (TextView) findViewById(R.id.t1);
        txtname= (EditText) findViewById(R.id.txtname);
        txtpass= (EditText) findViewById(R.id.txtpass);
        t1.setOnClickListener(this);
        txt3= (TextView) findViewById(R.id.txt3);
        txt20= (TextView) findViewById(R.id.txt20);
        txt20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ss=new Intent(log_in.this,sign_in.class);
                startActivity(ss);
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(log_in.this,sign_in.class);
                startActivity(s);
            }
        });
        im1= (ImageView) findViewById(R.id.im1);
        Animation s = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        im1.startAnimation(s);

    }

    private void golink(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void save(View v){
        String name=txtname.getText().toString();
        String pass=txtpass.getText().toString();
        Cursor res=db1.check();
        if (res.getCount()==0){
            Toast.makeText(log_in.this,"information not exeist",Toast.LENGTH_SHORT).show();
        }
        while (res.moveToNext()){
            String  a=res.getString(1);
            String b=res.getString(2);
            if (a.equals(name)&&b.equals(pass)) {
                Intent i=new Intent(log_in.this,sliderActivity.class);
                startActivity(i);
                Toast.makeText(log_in.this,"wellcom",Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(log_in.this,sign_in.class);
        startActivity(i);
    }
    }

