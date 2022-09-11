package com.example.avestafani.tourism;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AVESTAFANI on 06/21/2022.
 */

public class sliderPrefmanager {

    private Context context;
    private static final String pref_name="sliderpref";
    private static final String ket_start="startslider";
    SharedPreferences pref;


    public sliderPrefmanager(Context context){
        this.context=context;
        pref=context.getSharedPreferences(pref_name,Context.MODE_PRIVATE);

    }
    public boolean startslider(){
        return pref.getBoolean(ket_start,true);

    }

    public void setstartslider(boolean start){
        pref.edit().putBoolean(ket_start,start).apply();
    }
}
