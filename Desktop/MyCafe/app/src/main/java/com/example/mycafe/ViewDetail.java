package com.example.mycafe;

import android.graphics.Bitmap;

public class ViewDetail {
    private int id;
    private String itemname;
    private Bitmap itemimage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Bitmap getItemimage() {
        return itemimage;
    }

    public void setItemimage(Bitmap itemimage) {
        this.itemimage = itemimage;
    }

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }

    public String getNooforders() {
        return nooforders;
    }

    public void setNooforders(String nooforders) {
        this.nooforders = nooforders;
    }

    public String getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(String totalitems) {
        this.totalitems = totalitems;
    }

    private  String totalcost;
    private String nooforders;
    private String totalitems;

    public ViewDetail(int id, String itemname, Bitmap itemimage, String totalcost, String nooforders, String totalitems) {
        this.id = id;
        this.itemname = itemname;
        this.itemimage = itemimage;
        this.totalcost = totalcost;
        this.nooforders = nooforders;
        this.totalitems = totalitems;
    }


}
