/**
 * SDcardUtil.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 273.cn. All rights reserved.
 */

package com.likebamboo.imagechooser.utils;

import android.os.Environment;

/**
 * SD卡操作工具类
 * 
 * @author likebamboo
 */
public class SDcardUtil {

    /**
     * 是否有SD卡
     * 
     * @return
     */
    public static boolean hasExternalStorage() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}
