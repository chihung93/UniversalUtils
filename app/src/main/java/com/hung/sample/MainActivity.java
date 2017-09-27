package com.hung.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import hungnc.com.universalutils.DeviceUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MainActivity.class.getSimpleName(),String.valueOf(DeviceUtil.getDeviceHeight()));
    }
}
