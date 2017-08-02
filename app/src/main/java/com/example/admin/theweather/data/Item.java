package com.example.admin.theweather.Data;

/**
 * Created by Admin on 02.08.2017.
 */

public class Item {
    private int icon;
    private String title;

    public Item(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
