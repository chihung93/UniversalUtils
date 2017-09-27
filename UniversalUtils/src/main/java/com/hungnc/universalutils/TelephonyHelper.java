package com.hungnc.universalutils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class TelephonyHelper {

    public static boolean canPerformCall(@NonNull Context context) {
        if (!context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
            return false;
        }

        final TelephonyManager manager = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);

        return manager.getSimState() == TelephonyManager.SIM_STATE_READY
                && manager.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE;
    }

    public static boolean canSendSms(Context context) {
        if (!canPerformCall(context)) {
            return false;
        }

        if (Build.VERSION.SDK_INT < 19) {
            return true;
        } else {
            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(context);
            return defaultSmsPackageName != null;
        }
    }

    public static void call(Context context, String phone) {
        if (context != null && !TextUtils.isEmpty(phone) && TextUtils.isDigitsOnly(phone) && canPerformCall(context)) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phone));
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                context.startActivity(callIntent);
            }
        }
    }

}
