package com.example.avestafani.tourism;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AVESTAFANI on 06/21/2022.
 */

public class dbhelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "avestadep";
    public static final String TABLE_NAME1 = "tb1";
    public static final String TABLE_NAME2="tb2";

    public dbhelper(Context context ){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME1 + "(id INTEGER PRIMARY KEY AutoIncrement,name TEXT,pass TEXT)");
        db.execSQL(" CREATE TABLE "+TABLE_NAME2+"(id INTEGER PRIMARY KEY AutoIncrement,name TEXT,image BLOB,loc TEXT,date TEXT,fri TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }




    public boolean insertData2(String n,byte[]img,String l,String d,String f){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues i=new ContentValues();
        i.put("name",n);
        i.put("image",img);
        i.put("loc",l);
        i.put("date",d);
        i.put("fri",f);
        long result=db.insert(TABLE_NAME2,null,i);
        if (result==-1)
            return false;
        else
            return true;

    }
    public boolean in(String n, String p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues q = new ContentValues();
        q.put("name", n);
        q.put("pass", p);
        long result = db.insert(TABLE_NAME1, null, q);
        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor check() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery(" SELECT * FROM " + TABLE_NAME1, null);
        return result;


    }
}
