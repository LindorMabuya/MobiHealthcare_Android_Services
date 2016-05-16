package com.mabuya.lindor.mobilehealthacre_android_services.config.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by 213036223 on 4/22/2016.
 */
public class App extends Application{

    private static Context context;

    private static App singleton;

    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext() {
        return App.context;
    }

    public static final String TAG = App.class
            .getSimpleName();




    public static synchronized App getInstance() {
        return singleton;
    }
}
