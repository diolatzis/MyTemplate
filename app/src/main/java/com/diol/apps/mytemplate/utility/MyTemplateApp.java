package com.diol.apps.mytemplate.utility;

import android.app.Application;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


/**
 * Created by stavros.diolatzis on 20/2/2017.
 */

public class MyTemplateApp extends Application {

    private static MyTemplateApp instance;
    private String language;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        language = Locale.getDefault().getLanguage();
    }

    public static MyTemplateApp getInstance(){return instance;}

    public String getLanguage(){return language;}

}
