package com.example.admin.theweather;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.admin.theweather.listeners.FindConnectionListener;
import com.example.admin.theweather.receivers.NetworkReceiver;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class Forecast extends AppCompatActivity implements FindConnectionListener{
    public final static String BROADCAST_ACTION = "ru.networkreceiver.networkconnection";

    private NetworkReceiver networkReceiver;

    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
        networkReceiver = new NetworkReceiver(this);

        registerReceiver();
        sendBroadcast();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewFlipper.setDisplayedChild(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkReceiver);
    }

    public void registerReceiver(){
        IntentFilter intentFilter = new IntentFilter(BROADCAST_ACTION);
        registerReceiver(networkReceiver, intentFilter);
    }

    public void sendBroadcast(){
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION);
        sendBroadcast(intent);
    }

    @Override
    public void connectionFind() {

        String typeInternetConnection = App.getInstance().getTypeInternetConnection();
        if(typeInternetConnection.equals(getResources().getString(R.string.wifi_connection)) ||
                typeInternetConnection.equals(getResources().getString(R.string.internet_connection)))
        {
            viewFlipper.setDisplayedChild(1);
        } else {
            viewFlipper.setDisplayedChild(2);
        }
    }
}
