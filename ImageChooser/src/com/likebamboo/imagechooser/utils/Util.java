/**
 * TaskUtil.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 273.cn. All rights reserved.
 */

package com.likebamboo.imagechooser.utils;

import android.content.Context;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * 工具类
 * 
 * @author likebamboo
 * @date 2014-4-26
 */
public class Util {
    /**
     * 获取已选中个图片列表
     * 
     * @param context
     * @return
     */
    public static ArrayList<String> getSeletedImages(Context context) {
        ArrayList<String> selectedList = new ArrayList<String>();
        String images = ConfigUtil.getInstance(context).get(ConfigUtil.C_SELECTED_IMAGES);
        if (TextUtils.isEmpty(images)) {
            return selectedList;
        }
        String[] imgArr = images.split(",");
        for (String item : imgArr) {
            if (TextUtils.isEmpty(item)) {
                continue;
            }
            selectedList.add(item);
        }
        return selectedList;
    }

    /**
     * 保存选中的图片
     * 
     * @param context
     * @param imgList
     */
    public static void saveSelectedImags(Context context, ArrayList<String> imgList) {
        if (imgList == null) {
            return;
        }
        StringBuffer result = new StringBuffer("");
        for (String item : imgList) {
            result.append(item).append(",");
        }
        ConfigUtil.getInstance(context).save(ConfigUtil.C_SELECTED_IMAGES, result.toString());
    }

}
