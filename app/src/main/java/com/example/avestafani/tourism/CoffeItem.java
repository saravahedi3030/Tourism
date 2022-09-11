package com.example.avestafani.tourism;

/**
 * Created by AVESTAFANI on 08/18/2022.
 */

public class CoffeItem {
    private int imageresource;
    private String title;
    private String key_id;
    private String favstutus;

    public CoffeItem() {

    }

    public CoffeItem(int imageresource, String title, String key_id, String favstutus) {
        this.imageresource = imageresource;
        this.title = title;
        this.key_id = key_id;
        this.favstutus = favstutus;
    }

    public int getImageresource() {
        return imageresource;
    }

    public void setImageresource(int imageresource) {
        this.imageresource = imageresource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavstutus() {
        return favstutus;
    }

    public void setFavstutus(String favstutus) {
        this.favstutus = favstutus;
    }




}
