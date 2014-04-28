/**
 * FileUtil.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 273.cn. All rights reserved.
 */

package com.likebamboo.imagechooser.utils;

import android.text.TextUtils;

/**
 * 与文件相关工具类
 * 
 * @author likebamboo
 */
public class FileUtil {
    private FileUtil() {

    }

    /**
     * <p>
     * 对本地文件路径格式化
     * <p>
     * 其实就是加上 file://
     * 
     * @return
     */
    public static String getFormatFilePath(String path) {
        if (TextUtils.isEmpty(path)) {
            return "";
        }
        if (path.startsWith("file://")) {
            return path;
        }
        return "file://" + path;
    }
}
