package com.example.avestafani.tourism;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5, img6, img7, img8;
    TextView txt1,txt2,txt;
    LinearLayout lin;
     int i=0;
    private Handler handler=new Handler();
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        txt= (TextView) findViewById(R.id.txt);
        lin= (LinearLayout) findViewById(R.id.lin);

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i<=100){
                    txt.setText("" + 30);
                    progressBar.setProgress(i);
                    i++;
                    handler.postDelayed(this,50);



                }else {
                    handler.removeCallbacks(this);
                    Intent k = new Intent(MainActivity.this,log_in.class);
                    startActivity(k);
                    finish();

                }

            }
        },50);





        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);

        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        img2.startAnimation(a);

        Animation as = AnimationUtils.loadAnimation(this, R.anim.fadein);
        lin.startAnimation(as);


        Animation korh = AnimationUtils.loadAnimation(this, R.anim.fadein);
        img1.startAnimation(korh);


    }
}