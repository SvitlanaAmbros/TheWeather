package com.example.admin.theweather.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.admin.theweather.R;
import com.example.admin.theweather.listeners.FindConnectionListener;
import com.example.admin.theweather.App;

/**
 * Created by Admin on 27.07.2017.
 */

public class NetworkReceiver extends BroadcastReceiver {
    public String currentlyConnection = "";
    private FindConnectionListener listener;

    public NetworkReceiver(FindConnectionListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                currentlyConnection = context.getResources().getString(R.string.wifi_connection);
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                currentlyConnection = context.getResources().getString(R.string.internet_connection);
            }
        }else {
            currentlyConnection = context.getResources().getString(R.string.no_internet_connection);
        }

        App.getInstance().setTypeInternetConnection(currentlyConnection);
        listener.connectionFind();
    }
}
