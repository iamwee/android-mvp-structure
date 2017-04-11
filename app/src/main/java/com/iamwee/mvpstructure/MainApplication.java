package com.iamwee.mvpstructure;

import android.app.Application;

import com.iamwee.mvpstructure.util.Contextor;


public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().initialize(getApplicationContext());
    }
}
