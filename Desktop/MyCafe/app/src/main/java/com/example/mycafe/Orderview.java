package com.example.mycafe;

public class Orderview {
    private  int ID;

    public Orderview(int ID, String fname, String recievingtime, String status) {
        this.ID = ID;
        this.fname = fname;
        this.recievingtime = recievingtime;
        this.status = status;
    }

    private String fname;
    private  String recievingtime;
    private  String status;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getRecievingtime() {
        return recievingtime;
    }

    public void setRecievingtime(String recievingtime) {
        this.recievingtime = recievingtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
