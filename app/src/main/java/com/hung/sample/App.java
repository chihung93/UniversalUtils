package com.hung.sample;

import android.app.Application;

import hungnc.com.universalutils.ContextHelper;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ContextHelper.init(this);
    }
}
