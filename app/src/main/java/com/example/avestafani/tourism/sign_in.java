package com.example.avestafani.tourism;

import android.content.Intent;
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

public class sign_in extends AppCompatActivity {
    dbhelper db1;
    EditText txtname, txtpass, txtpass2;
    String i = "";
    TextView txt1,txt2,t1;
     FloatingActionButton fab_plus,fab_twiter,fab_mail;
    Animation fabopen,fabclose,fablock,fabclock2;
    boolean isopen=false;
    ImageView im1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fab_plus= (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_twiter= (FloatingActionButton) findViewById(R.id.fab_twiter);
        fab_mail= (FloatingActionButton) findViewById(R.id.fab_mail);


        fab_twiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golink("https://www.telegram.com");
            }
        });

        fab_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golink("https://www.mail.com");

            }
        });

        im1= (ImageView) findViewById(R.id.im1);
        Animation s = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        im1.startAnimation(s);
        fabopen= AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabclose= AnimationUtils.loadAnimation(this, R.anim.fab_close);
        fablock= AnimationUtils.loadAnimation(this, R.anim.rotate_close);
        fabclock2= AnimationUtils.loadAnimation(this, R.anim.rotate_lock);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isopen){
                    fab_mail.startAnimation(fabclose);
                    fab_twiter.startAnimation(fabclose);
                    fab_plus.startAnimation(fabclock2);
                    fab_twiter.setClickable(false);
                    fab_mail.setClickable(false);
                    isopen=false;
                }
                else {
                    fab_mail.startAnimation(fabopen);
                    fab_twiter.startAnimation(fabopen);
                    fab_plus.startAnimation(fablock);
                    fab_twiter.setClickable(true);
                    fab_mail.setClickable(true);
                    isopen=true;
                }
            }
        });



        db1 = new dbhelper(this);
        txtname = (EditText) findViewById(R.id.txtname);
        txtpass = (EditText) findViewById(R.id.txtpass);
        txtpass2 = (EditText) findViewById(R.id.txtpass2);
        txt1= (TextView) findViewById(R.id.txt1);
        t1= (TextView) findViewById(R.id.t1);
        txt2= (TextView) findViewById(R.id.txt2);
       txt1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent a = new Intent(sign_in.this, log_in.class);
               startActivity(a);
           }
       });

        Animation x1 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        t1.startAnimation(x1);

    }

    private void golink(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void save(View v) {
        String name = txtname.getText().toString().trim();
        String pass = txtpass.getText().toString().trim();
        String pass2 = txtpass2.getText().toString().trim();
        if (pass.equals(pass2)) {
            boolean a = db1.in(name, pass);
            if (a == true) {

                Intent i = new Intent(sign_in.this, log_in.class);
                startActivity(i);
                Toast.makeText(sign_in.this, "username and password saved", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(sign_in.this, "username and password no saved", Toast.LENGTH_SHORT).show();


            }

        } else {
            Toast.makeText(sign_in.this, "password matching", Toast.LENGTH_SHORT).show();

        }



    }



    }

