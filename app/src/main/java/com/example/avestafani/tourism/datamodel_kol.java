package com.example.avestafani.tourism;

/**
 * Created by AVESTAFANI on 09/07/2022.
 */

public class datamodel_kol {

    private String txt1;
    private String txt2;
    private String txt3;
    private int image;
    boolean visiblity;




    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    public String getTxt3() {
        return txt3;
    }

    public void setTxt3(String txt3) {
        this.txt3 = txt3;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isVisiblity() {
        return visiblity;
    }

    public void setVisiblity(boolean visiblity) {
        this.visiblity = visiblity;
    }


    public datamodel_kol(String txt1, String txt2,String txt3, int image) {
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;
        this.image = image;
    }
}
