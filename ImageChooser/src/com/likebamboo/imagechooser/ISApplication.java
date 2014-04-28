/**
 * ISApplication.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Application，程序入口
 * 
 * @author likebamboo
 */
public class ISApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        initImageLoader(getApplicationContext());
    }

    /**
     * 获取Application的 上下文对象
     * 
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 初始化ImageLoader
     * 
     * @param context
     */
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .memoryCache(new WeakMemoryCache()).discCacheSize(8 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO);
        // 如果是调试模式，输出日志，否则不输出
        if (BuildConfig.DEBUG) {
            builder.writeDebugLogs();
        }
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(builder.build());
    }

}
