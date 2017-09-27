package com.hungnc.universalutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkUtil {

    public static NetworkInfo getNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) ContextHelper.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public static boolean isNetworkAvailable() {
        NetworkInfo netInfo = getNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static boolean isConnectedWifi() {
        NetworkInfo info = getNetworkInfo();
        return (isNetworkAvailable() && info.getType() == ConnectivityManager.TYPE_WIFI);
    }

    public static boolean isConnectedMobile() {
        NetworkInfo info = getNetworkInfo();
        return (isNetworkAvailable() && info.getType() == ConnectivityManager.TYPE_MOBILE);
    }
}
