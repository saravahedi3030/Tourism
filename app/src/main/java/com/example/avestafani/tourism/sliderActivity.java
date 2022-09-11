package com.example.avestafani.tourism;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class sliderActivity extends AppCompatActivity {
    ViewPager viewpager;
    LinearLayout layoutdots;
    int[]layouts={R.layout.slid1,R.layout.slid2,R.layout.slid3};
    Button btn_next,btn_skip ;
    adapter pageradapter;
    private sliderPrefmanager prefman;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        prefman=new sliderPrefmanager(this);

        viewpager= (ViewPager) findViewById(R.id.viewpager);
        layoutdots= (LinearLayout) findViewById(R.id.layoutdots);
        btn_next= (Button) findViewById(R.id.btn_next);
        btn_skip= (Button) findViewById(R.id.btn_skip);
        viewpager.setAdapter(new adapter());
        pageradapter=new adapter();
        showdots(viewpager.getCurrentItem());
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                showdots(position);
                if (position==viewpager.getAdapter().getCount()-1){
                    btn_skip.setVisibility(View.GONE);
                    btn_next.setText(R.string.GoToIt);
                }
                else {
                    btn_skip.setVisibility(View.VISIBLE);
                    btn_next.setText(R.string.next);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    private void showdots(int pagenumber) {
        TextView[]dots=new TextView[layouts.length];
        layoutdots.removeAllViews();
        for (int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
            dots[i].setTextColor(ContextCompat.getColor(this,i==pagenumber?R.color.colorAccent:R.color.colorPrimary));
            layoutdots.addView(dots[i]);
        }
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentpage=viewpager.getCurrentItem();
                int lastpage=viewpager.getAdapter().getCount()-1;
                if (currentpage==lastpage){
                    prefman.setstartslider(false);
                    Intent i=new Intent(sliderActivity.this,navagation1.class);
                    startActivity(i);

                }
                else {
                    viewpager.setCurrentItem(currentpage+1);
                }

            }

        });
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(sliderActivity.this,navagation1.class);
                startActivity(i);
            }
        });
    }

    public class adapter extends PagerAdapter{


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= LayoutInflater.from(sliderActivity.this).inflate(layouts[position],container,false);
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(sliderActivity.this,"hello",Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=(View)object;
        container.removeView(view);    }
}


}
