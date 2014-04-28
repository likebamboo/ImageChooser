/**
 * BaseTask.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.task;

import android.os.AsyncTask;

import com.likebamboo.imagechooser.listener.OnTaskResultListener;

/**
 * 异步任务基类
 * 
 * @author likebamboo
 */
public abstract class BaseTask extends AsyncTask<Void, Void, Boolean> {

    /**
     * 失败的时候的错误提示
     */
    protected String error = "";

    /**
     * 是否被终止
     */
    protected boolean interrupt = false;

    /**
     * 结果
     */
    protected Object result = null;

    /**
     * 异步任务执行完后的回调接口
     */
    protected OnTaskResultListener resultListener = null;

    @Override
    protected void onPostExecute(Boolean success) {
        if (!interrupt && resultListener != null) {
            resultListener.onResult(success, error, result);
        }
    }

    /**
     * 中断异步任务
     */
    public void cancel() {
        super.cancel(true);
        interrupt = true;
    }

    public void setOnResultListener(OnTaskResultListener listener) {
        resultListener = listener;
    }

}
