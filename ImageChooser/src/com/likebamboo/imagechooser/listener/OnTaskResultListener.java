/**
 * OnTaskResultListener.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.listener;

/**
 * 异步任务执行完后回调接口
 * 
 * @author likebamboo
 */
public interface OnTaskResultListener {
    /**
     * 回调函数
     * 
     * @param success 是否成功
     * @param error 错误信息，[成功的时候错误信息为空]
     * @param result 获取到的结果
     */
    void onResult(final boolean success, final String error, final Object result);
}
