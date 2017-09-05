package com.diol.apps.mytemplate.utility;

import android.app.Application;

import com.squareup.otto.Bus;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * Created by stavros.diolatzis on 20/2/2017.
 */

public class MyTemplateApp extends Application {

    private static MyTemplateApp instance;
    private String language;
    private Bus eventBus;
    private OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        language = Locale.getDefault().getLanguage();
        okHttpClient = createOkHttpClinet();
        eventBus = new Bus();
    }

    private OkHttpClient createOkHttpClinet()
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(logging).build();
    }

    public OkHttpClient getOkHttpClient() {return okHttpClient;}

    public static MyTemplateApp getInstance(){return instance;}

    public Bus getEventBus(){return eventBus;}

    public String getLanguage(){return language;}

}
