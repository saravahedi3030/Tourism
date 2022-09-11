package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class show_resturan extends AppCompatActivity {

    TextView txt1,txt2,t1,t2,t3;
    ImageView img1,img11, img12, img13, img14, img15, img16, img17, img18, img19, img20,imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_resturan);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        t1= (TextView) findViewById(R.id.t1);
        t2= (TextView) findViewById(R.id.t2);
        t3= (TextView) findViewById(R.id.t3);
        img1= (ImageView) findViewById(R.id.img1);
        img11= (ImageView) findViewById(R.id.img11);
        img12= (ImageView) findViewById(R.id.img12);
        img13= (ImageView) findViewById(R.id.img13);
        img14= (ImageView) findViewById(R.id.img14);
        img15= (ImageView) findViewById(R.id.img15);
        img16= (ImageView) findViewById(R.id.img16);
        img17= (ImageView) findViewById(R.id.img17);
        img18= (ImageView) findViewById(R.id.img18);
        img19= (ImageView) findViewById(R.id.img19);
        img20= (ImageView) findViewById(R.id.img20);
        imgback= (ImageView) findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z=new Intent(show_resturan.this,kermanshah_bazar.class);
                startActivity(z);
            }
        });

        Intent i=getIntent();
        String name=i.getStringExtra("name");
        String name1=i.getStringExtra("name1");
        String tt1=i.getStringExtra("n1");
        String tt2=i.getStringExtra("n2");
        String tt3=i.getStringExtra("n3");
        int image=i.getIntExtra("img",0);
        int image1=i.getIntExtra("img1",0);
        int image2=i.getIntExtra("img2",0);
        int image3=i.getIntExtra("img3",0);
        int image4=i.getIntExtra("img4",0);
        int image5=i.getIntExtra("img5",0);
        int image6=i.getIntExtra("img6",0);
        int image7=i.getIntExtra("img7",0);
        int image8=i.getIntExtra("img8",0);
        int image9=i.getIntExtra("img9",0);
        int image10=i.getIntExtra("img10",0);
        txt1.setText(name);
        txt2.setText(name1);
        t1.setText(tt1);
        t2.setText(tt2);
        t3.setText(tt3);
        img1.setImageResource(image);
        img11.setImageResource(image1);
        img12.setImageResource(image2);
        img13.setImageResource(image3);
        img14.setImageResource(image4);
        img15.setImageResource(image5);
        img16.setImageResource(image6);
        img17.setImageResource(image7);
        img18.setImageResource(image8);
        img19.setImageResource(image9);
        img20.setImageResource(image10);

    }
}
