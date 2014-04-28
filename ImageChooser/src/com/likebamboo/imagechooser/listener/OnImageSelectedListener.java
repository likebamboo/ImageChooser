/**
 * OnTaskResultListener.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.listener;

/**
 * 图片选中(或取消选中)回调借口
 * 
 * @author likebamboo
 * @date 2014-4-26
 */
public interface OnImageSelectedListener {
    /**
     * @param path 图片路径
     * @param selected 是否选中
     */
    void onImageSeleted(final String path, final boolean selected);
}
