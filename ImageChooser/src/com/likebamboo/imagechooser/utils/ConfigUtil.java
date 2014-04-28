/**
 * ConfigUtil.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-24
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 配置信息(sharedPreference)工具类
 * 
 * @author likebamboo
 * @date 2014-4-26
 */
public class ConfigUtil {

    /**
     * 配置文件名称
     */
    private static String PREF_NAME = "ic_config";

    /**
     * 选中的图片列表配置项名称
     */
    public static String C_SELECTED_IMAGES = "c_selected_images";

    /**
     * 
     */
    private static ConfigUtil mInstance = null;

    /**
     * 上下文对象
     */
    private Context mContext = null;

    /**
     * 
     */
    protected SharedPreferences mSettings = null;

    /**
     * 
     */
    protected SharedPreferences.Editor mEditor = null;

    /**
     * 锁
     */
    private static Object lock = new Object();

    private ConfigUtil(Context context) {
        mContext = context;
        mSettings = mContext.getSharedPreferences(PREF_NAME, 0);
        mEditor = mSettings.edit();

    }

    /**
     * 获取单例
     * 
     * @param context
     * @return
     */
    public static ConfigUtil getInstance(Context context) {
        if (mInstance == null) {
            synchronized (lock) {
                if (mInstance == null) {
                    mInstance = new ConfigUtil(context.getApplicationContext());
                }
            }
        }
        return mInstance;
    }

    public boolean contains(String key) {
        return mSettings.contains(key);
    }

    public String get(String key) {
        return mSettings.getString(key, "");
    }

    public String get(String key, String defValue) {
        return mSettings.getString(key, defValue);
    }

    public void save(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public void remove(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }

    public void clear() {
        mEditor.clear();
        mEditor.commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSettings.getBoolean(key, defValue);
    }

    public void saveBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public int getInt(String key, int defValue) {
        return mSettings.getInt(key, defValue);
    }

    public void saveInt(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public long getLong(String key, long defValue) {
        return mSettings.getLong(key, defValue);
    }

    public void saveLong(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.commit();
    }

}
