package com.example.admin.theweather;

import android.app.Application;

/**
 * Created by Admin on 27.07.2017.
 */

public class App extends Application {

    private static App instance;
    private String typeInternetConnection;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        typeInternetConnection = "No internet connection";
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }

    public static App getInstance(){
        return instance;
    }

    public String getTypeInternetConnection() {
        return typeInternetConnection;
    }

    public void setTypeInternetConnection(String typeInternetConnection) {
        this.typeInternetConnection = typeInternetConnection;
    }
}