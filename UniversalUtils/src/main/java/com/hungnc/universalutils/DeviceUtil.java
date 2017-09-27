package com.hungnc.universalutils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;

import java.util.List;

public final class DeviceUtil {

    public static int getDeviceWidth() {
        return ContextHelper.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getDeviceHeight() {
        return ContextHelper.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static boolean hasAppInstalled(String pkgName) {
        try {
            ContextHelper.getContext().getPackageManager().getPackageInfo(pkgName, PackageManager.PERMISSION_GRANTED);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isAppRunInBackground() {
        ActivityManager activityManager = (ActivityManager) ContextHelper.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(ContextHelper.getContext().getPackageName())) {
                // return true -> Run in background
                // return false - > Run in foreground
                return appProcess.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
            }
        }
        return false;
    }
}
