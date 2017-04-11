package com.iamwee.mvpstructure.manager;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null) instance = new HttpManager();
        return instance;
    }

    public ApiService getService() {
        return getEngine().create(ApiService.class);
    }

    public <T> T getService(Class<T> cs) {
        return getEngine().create(cs);
    }

    private Retrofit getEngine() {
        return getEngine("");
    }

    private Retrofit getEngine(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
