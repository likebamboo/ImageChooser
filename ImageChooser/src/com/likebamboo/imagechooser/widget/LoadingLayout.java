/**
 * LoadingLayout.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.likebamboo.imagechooser.R;

/**
 * 整块区域的Loading
 * 
 * @author likebamboo
 */
public class LoadingLayout extends LinearLayout {
    /**
     * 正在加载ProgressBar
     */
    private ProgressBar mLoadingProgressBar = null;

    /**
     * 重试布局
     */
    private LinearLayout mRetryLayout = null;

    /**
     * 错误提示TextView
     */
    private TextView mErrorTv = null;

    /**
     * 重试接口
     */
    private IRetryListener mRetryListener = null;

    /**
     * 是否可以重试
     */
    private boolean canRetry = true;

    public interface IRetryListener {
        void onRetry();
    }

    public LoadingLayout(Context context) {
        super(context);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        mLoadingProgressBar = (ProgressBar)findViewById(R.id.loading_pb);
        mRetryLayout = (LinearLayout)findViewById(R.id.loading_fail_layout);
        mRetryLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!canRetry) {
                    return false;
                }
                // onTouch down的时候才触发重试异步线程，否则会多次触发的。
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (mRetryListener != null) {
                        mRetryListener.onRetry();
                    }
                }
                return true;
            }
        });
        mErrorTv = (TextView)findViewById(R.id.loading_fail_tv);
    }

    /**
     * 显示/隐藏正在加载中。。。
     */
    public void showLoading(boolean show) {
        if (show) {
            setVisibility(View.VISIBLE);
            mLoadingProgressBar.setVisibility(View.VISIBLE);
            mRetryLayout.setVisibility(View.GONE);
        } else {
            setVisibility(View.GONE);
        }
    }

    /**
     * 显示加载失败信息
     */
    public void showFailed(CharSequence msg) {
        setVisibility(View.VISIBLE);
        mLoadingProgressBar.setVisibility(View.GONE);
        mRetryLayout.setVisibility(View.VISIBLE);
        mErrorTv.setText(msg);
        mErrorTv.setTextColor(getResources().getColor(android.R.color.black));
        if (!canRetry) {
            canRetry = true;
        }
    }

    /**
     * 显示"空"信息
     * 
     * @param msg
     */
    public void showEmpty(CharSequence msg) {
        setVisibility(View.VISIBLE);
        mLoadingProgressBar.setVisibility(View.GONE);
        mRetryLayout.setVisibility(View.VISIBLE);
        mErrorTv.setText(msg);
        mErrorTv.setTextColor(getResources().getColor(android.R.color.background_dark));
        mErrorTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        canRetry = false;
    }

    /**
     * 设置重试监听器。
     * 
     * @param listener
     */
    public void setRetryListener(IRetryListener listener) {
        this.mRetryListener = listener;
    }

}
