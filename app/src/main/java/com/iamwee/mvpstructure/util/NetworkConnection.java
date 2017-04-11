package com.iamwee.mvpstructure.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkConnection {
    private static NetworkConnection instance;

    public static NetworkConnection getInstance() {
        if (instance == null) instance = new NetworkConnection();
        return instance;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) Contextor
                .getInstance()
                .getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}

