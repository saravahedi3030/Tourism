package com.example.avestafani.tourism;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by AVESTAFANI on 07/26/2022.
 */


public class dbhelper1 extends SQLiteOpenHelper {
    public static final String DB_NAME="avesta";
    public static final String TABLE_NAME2="tb2";
    public static final String TABLE_NAME3="tb3";
    private static String KEY_ID="id";
    private static String ITEM_TITLE="item_Title";
    private static String ITEM_IMAGE="item_Image";
    private static String FAVORITE_STATUS="fStatus";
    public dbhelper1(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(" CREATE TABLE "+TABLE_NAME2+"(id INTEGER PRIMARY KEY AutoIncrement,name TEXT,image BLOB,loc TEXT,date TEXT,fri TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
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
    public Cursor getData1(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("SELECT * FROM " +TABLE_NAME2,null);
        return result;
    }

    public boolean deletedata(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        long result=db.delete(TABLE_NAME2,"name=?" ,new String[]{name});
        if (result==0)
            return false;
        else
            return true;
    }


    public void insertEmpty(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        for (int x=1;x<11;x++){
            cv.put("KEY_ID",x);
            cv.put("FAVORITE_STATUS","0");
            db.insert(TABLE_NAME3,null,cv);

        }
    }

    public void insertInto(String item_title,int item_image,String id,String fav_status){
        SQLiteDatabase db;
        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ITEM_TITLE",item_title);
        cv.put("ITEM_IMAGE",item_image);
        cv.put("KEY_ID",id);
        cv.put("FAVORITE_STATUS",fav_status);
        db.insert(TABLE_NAME3,null,cv);
        Log.d("favDB status",item_title + ",favstatus - "+fav_status+" - +" + cv);

    }

    public Cursor readalldata(String id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor sql=db.rawQuery("SELECT * FROM " +TABLE_NAME3 + " where " + KEY_ID+"="+id+"",null);
        return sql;

    }


    public void remove(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql= "UPDATE " + TABLE_NAME3 + " SET "+ FAVORITE_STATUS+" ='0' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove",id.toString());
    }




}





