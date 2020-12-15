package com.github.overcastan.recyclerview;

import android.widget.ImageView;

public class Data {
    private long id;
    private String mainInfo;
    private String date;
    private int imageID;


    public Data(final long id, final String mainInfo) {
        this.id = id;
        this.mainInfo = mainInfo;
        this.date = "";
        this.imageID = 0;
    }

    public long getId() {
        return id;
    }

    public String getInfo() {
        return mainInfo;
    }

    public String getDate() {
        return date;
    }

    public int getImage() {
        return imageID;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public void setImageID (int ID) {
        this.imageID = ID;
    }
}
