package com.iamwee.mvpstructure.bus;

import org.greenrobot.eventbus.EventBus;

public class BusProvider extends EventBus {

    private static BusProvider instance;

    public static BusProvider getInstance() {
        if (instance == null) instance = new BusProvider();
        return instance;
    }
}
