package com.diol.apps.mytemplate.api;

import com.diol.apps.mytemplate.utility.MyTemplateApp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.diol.apps.mytemplate.utility.Config.BASE_URL;

/**
 * Created by diola on 6/9/2017.
 */

public class WebServiceCalls {

    private static Retrofit retrofit = null;


    public static Retrofit getRetrofitEngine() {

        OkHttpClient okHttpClient = MyTemplateApp.getInstance().getOkHttpClient();

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
