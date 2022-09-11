package com.example.avestafani.tourism;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class safar_my extends AppCompatActivity {

    EditText txtname1,txtloc,data1,txtdes;
    Button d1,btnshow;
    ImageView imgava,imgback;
    DatePickerDialog datePickerDialog;
    dbhelper1 dp15;
    int id=0;
    LinearLayout ml;
    private static final int IMAG_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safar_my);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtname1 = (EditText) findViewById(R.id.txtname1);
        txtloc = (EditText) findViewById(R.id.txtloc);
        data1 = (EditText) findViewById(R.id.data1);
        txtdes = (EditText) findViewById(R.id.txtdes);
        imgava = (ImageView) findViewById(R.id.imgava);
        imgback = (ImageView) findViewById(R.id.imgback);
        d1 = (Button) findViewById(R.id.d1);
        btnshow = (Button) findViewById(R.id.bshow);
        dp15 = new dbhelper1(this);
        ml = (LinearLayout) findViewById(R.id.ml);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h=new Intent(safar_my.this,navagation1.class);
                startActivity(h);
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l=new Intent(safar_my.this,show_safar.class);
                startActivity(l);
            }
        });

        imgava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(safar_my.this);
                builder.setTitle("Chose Image");
                builder.setMessage("Chose Image...");
                builder.setCancelable(false);
                builder.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent I = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(I, 0);
                    }
                });
                builder.setNegativeButton("Gallry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                                    == PackageManager.PERMISSION_DENIED) {
                                //permission not granted,request it.
                                String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                                //show popup for runtime permission
                                requestPermissions(permissions, PERMISSION_CODE);

                            } else {
                                // permission already granted
                                pickImageFormatGallery();


                            }

                        } else {
                            //system os is less then marshmallow
                            pickImageFormatGallery();
                        }
                    }
                });
                builder.show();
            }
        });

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker datePicker = new DatePicker(safar_my.this);
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                datePickerDialog = new DatePickerDialog(safar_my.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        data1.setText("day:" + dayOfMonth + "Month:" + (month + 1) + "Year:" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });
    }





    private void pickImageFormatGallery() {

        //intent to pick image
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAG_PICK_CODE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //handle result of runtime permisission

        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){

                    //permission was granted
                    pickImageFormatGallery();

                }
                else {
                    //perimission was granted
                    Toast.makeText(safar_my.this,"permissin denied ...!",Toast.LENGTH_SHORT).show();

                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK&&requestCode==IMAG_PICK_CODE){
            imgava.setImageURI(data.getData());




        }
        else {
            Bitmap bmp=(Bitmap)data.getExtras().get("data");
            imgava.setImageBitmap(bmp);
            saveimage(bmp);

        }
        return;    }

    private void saveimage(Bitmap bmp) {
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] bytes=stream.toByteArray();
        String name= txtname1.getText().toString();
        String loc=txtloc.getText().toString();
        String des=txtdes.getText().toString();
        String date=data1.getText().toString();
        boolean res=dp15.insertData2(name,bytes,loc,date+"",des);
        if (res==true){
            Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
        }


    }
}
