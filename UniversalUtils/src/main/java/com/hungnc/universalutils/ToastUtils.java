package com.hungnc.universalutils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    /**
     * Displays a short toast wherever the method is called.
     *
     * @param mContext application context.
     * @param message  your message.
     */
    public static void showShort(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays a long tast wherever the method is called.
     * @param mContext application context.
     * @param message your message.
     */
    public static void showLong(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

}
