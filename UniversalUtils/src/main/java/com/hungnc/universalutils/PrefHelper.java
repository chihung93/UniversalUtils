package com.hungnc.universalutils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefHelper {

    private final static String PREF_FILE = "PREF";

    private static PrefHelper instance = null;

    protected Context context;
    protected String fileName;

    public PrefHelper() {
        this.context = ContextHelper.getContext();
        this.fileName = PREF_FILE;
    }

    public static PrefHelper getInstance() {
        if (instance == null) {
            instance = new PrefHelper();
        }
        return instance;
    }

    // --------------------------- CONSTRUCTORS ---------------------------

    public PrefHelper(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public PrefHelper(Context context) {
        this.context = context;
        this.fileName = PREF_FILE;
    }

    // --------------------- GETTER / SETTER METHODS ---------------------

    protected SharedPreferences getPref() {
        return getPref(context);
    }

    protected SharedPreferences getPref(Context context) {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    protected SharedPreferences.Editor getEditor() {
        return getPref().edit();
    }

    protected SharedPreferences.Editor getEditor(Context context) {
        return getPref(context).edit();
    }

    // -------------------------- OTHER METHODS --------------------------

    /**
     * Set a string shared preference
     *
     * @param key   - Key to set shared preference
     * @param value - Value for the key
     */
    public void setString(String key, String value) {
        getEditor().putString(key, value).apply();
    }

    /**
     * Set a integer shared preference
     *
     * @param key   - Key to set shared preference
     * @param value - Value for the key
     */
    public void setInt(String key, int value) {
        getEditor().putInt(key, value).apply();
    }

    /**
     * Set a Boolean shared preference
     *
     * @param key   - Key to set shared preference
     * @param value - Value for the key
     */
    public void setBoolean(String key, boolean value) {
        getEditor().putBoolean(key, value).apply();
    }

    public void setBoolean(Context context,String key, boolean value) {
        getEditor(context).putBoolean(key, value).apply();
    }

    /**
     * Get a string shared preference
     *
     * @param key      - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public String getString(String key, String defValue) {
        return getPref().getString(key, defValue);
    }

    public String getString(String key) {
        return getPref().getString(key, "");
    }

    /**
     * Get a integer shared preference
     *
     * @param key      - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public int getInt(String key, int defValue) {
        return getPref().getInt(key, defValue);
    }

    public int getInt(String key) {
        return getPref().getInt(key, -1);
    }

    /**
     * Get a boolean shared preference
     *
     * @param key      - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public boolean getBoolean(String key, boolean defValue) {
        return getPref().getBoolean(key, defValue);
    }

    public boolean getBoolean(Context context,String key, boolean defValue) {
        return getPref(context).getBoolean(key, defValue);
    }

    public boolean getBoolean(String key) {
        return getPref().getBoolean(key, false);
    }
}
