package com.iamwee.mvpstructure.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private static Gson instance;

    public static Gson getInstance() {
        if (instance == null) {
            instance = new GsonBuilder().setPrettyPrinting().create();
        }
        return instance;
    }
}
