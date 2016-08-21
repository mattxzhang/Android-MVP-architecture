package com.kai.android_mvp_architecture;

import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {

    private static BaseApp instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static BaseApp getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }
}
