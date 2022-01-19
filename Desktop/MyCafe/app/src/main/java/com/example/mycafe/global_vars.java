package com.example.mycafe;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class global_vars extends Application {
    private int LoginUserID;

    public int getIdofgenerate() {
        return idofgenerate;
    }

    public void setIdofgenerate(int idofgenerate) {
        this.idofgenerate = idofgenerate;
    }

    private int idofgenerate;
    public ArrayList myGlobalArray = null;

    public float getAmounttopay() {
        return amounttopay;
    }

    public void setAmounttopay(float amounttopay) {
        this.amounttopay = amounttopay;
    }

    public float amounttopay;

    public global_vars() {
        myGlobalArray = new ArrayList();
    }

    public int getLoginUserID() {
        return LoginUserID;
    }

    public void setLoginUserID(int LoginUserID) {
        this.LoginUserID = LoginUserID;
    }
}
