package com.hungnc.universalutils;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonHelper {

    private static Boolean hasGson;
    private static Gson gson;

    public static boolean hasGson() {
        if (hasGson == null) {
            try {
                Class.forName("com.google.gson.Gson");
                hasGson = true;
            } catch (Exception e) {
                hasGson = false;
            }
        }
        return hasGson;
    }

    public static Gson get() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static String toJson(Object obj) {
        return get().toJson(obj);
    }

    public static <T> T fromJson(String str, Class<T> clazz) {
        return fromJson(str, (Type) clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String str, Type type) {
        try {
            return str == null ? null : (T) get().fromJson(str, type);
        } catch (Exception e) {
            Log.e("GsonHelper", "Cannot parse JSON to object", e);
            return null;
        }
    }

}
