package com.example.avestafani.tourism;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ertebat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ertebat);


        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("تماس با ما");
        builder.setMessage("083-8254545");
        builder.setIcon(android.R.drawable.ic_menu_call);
        builder.setPositiveButton("تایید", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(ertebat.this,navagation1.class);
                startActivity(i);
            }
        });

        builder.show();
    }
}
