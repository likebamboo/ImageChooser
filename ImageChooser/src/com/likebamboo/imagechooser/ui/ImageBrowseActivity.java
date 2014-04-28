/**
 * ImageBrowseActivity.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.likebamboo.imagechooser.R;
import com.likebamboo.imagechooser.ui.adapter.ImagePagerAdapter;

import java.util.ArrayList;

/**
 * 大图浏览Activity
 * 
 * @author likebamboo
 */
public class ImageBrowseActivity extends Activity {
    /**
     * 图片列表
     */
    public static final String EXTRA_IMAGES = "extra_images";

    /**
     * 位置
     */
    public static final String EXTRA_INDEX = "extra_index";

    /**
     * 图片列表数据源
     */
    private ArrayList<String> mDatas = new ArrayList<String>();

    /**
     * 进入到该界面时的索引
     */
    private int mPageIndex = 0;

    /**
     * 图片适配器
     */
    private ImagePagerAdapter mImageAdapter = null;

    /**
     * viewpager
     */
    private ViewPager mViewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_browse);
        mViewPager = (ViewPager)findViewById(R.id.image_vp);
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_IMAGES)) {
            mDatas = intent.getStringArrayListExtra(EXTRA_IMAGES);
            mPageIndex = intent.getIntExtra(EXTRA_INDEX, 0);
            mImageAdapter = new ImagePagerAdapter(mDatas);
            mViewPager.setAdapter(mImageAdapter);
            mViewPager.setCurrentItem(mPageIndex);
        }
    }

}
