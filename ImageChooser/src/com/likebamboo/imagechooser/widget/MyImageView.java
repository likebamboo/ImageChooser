/**
 * MyImageView.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.widget;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 自定义View，onMeasure方法中取图片宽和高
 * 
 * @author likebamboo
 */
public class MyImageView extends ImageView {

    /**
     * 记录控件的宽和高
     */
    private Point mPoint = new Point();

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mPoint.x = getMeasuredWidth();
        mPoint.y = getMeasuredHeight();
    }

    /**
     * 返回Point
     * 
     * @return
     */
    public Point getPoint() {
        return mPoint;
    }
}
