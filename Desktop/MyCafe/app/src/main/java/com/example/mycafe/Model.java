package com.example.mycafe;

import android.graphics.Bitmap;

import java.util.List;

public class Model {


    private int ID;
    private String CATEGORY;
    private String   ITEMNAME;
    private Bitmap ITEMIMAGE;
    private String  COST;
    private String STATUS;
    private String EXTRA;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getITEMNAME() {
        return ITEMNAME;
    }

    public void setITEMNAME(String ITEMNAME) {
        this.ITEMNAME = ITEMNAME;
    }

    public Bitmap getITEMIMAGE() {
        return ITEMIMAGE;
    }

    public void setITEMIMAGE(Bitmap ITEMIMAGE) {
        this.ITEMIMAGE = ITEMIMAGE;
    }

    public String getCOST() {
        return COST;
    }

    public void setCOST(String COST) {
        this.COST = COST;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getEXTRA() {
        return EXTRA;
    }

    public void setEXTRA(String EXTRA) {
        this.EXTRA = EXTRA;
    }



    public Model(int ID, String CATEGORY, String ITEMNAME, Bitmap ITEMIMAGE, String COST, String STATUS, String EXTRA) {
        this.ID = ID;
        this.CATEGORY = CATEGORY;
        this.ITEMNAME = ITEMNAME;
        this.ITEMIMAGE = ITEMIMAGE;
        this.COST = COST;
        this.STATUS = STATUS;
        this.EXTRA = EXTRA;

    }



}
