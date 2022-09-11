package com.example.avestafani.tourism;

import android.graphics.Bitmap;

/**
 * Created by AVESTAFANI on 03/06/2022.
 */

public class mymodel2 {
    public String name;
    public Bitmap proavator;
    public String location;
    public String date;
    public String friends;


    public mymodel2(String name, Bitmap proavator, String location, String date, String friends) {
        this.name = name;
        this.proavator = proavator;
        this.location = location;
        this.date = date;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getProavator() {
        return proavator;
    }

    public void setProavator(Bitmap proavator) {
        this.proavator = proavator;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }
}
