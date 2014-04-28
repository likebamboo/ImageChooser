/**
 * ImagePagerAdapter.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

import com.likebamboo.imagechooser.R;
import com.likebamboo.imagechooser.utils.FileUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import uk.co.senab.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

/**
 * 查看大图的ViewPager适配器
 * 
 * @author likebamboo
 */
public class ImagePagerAdapter extends PagerAdapter {
    /**
     * 数据源
     */
    private List<String> mDatas = new ArrayList<String>();

    /**
     * UIL的ImageLoader
     */
    private ImageLoader mImageLoader = ImageLoader.getInstance();

    /**
     * 显示参数
     */
    private DisplayImageOptions mOptions = null;

    public ImagePagerAdapter(ArrayList<String> dataList) {
        mDatas = dataList;
        mOptions = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.pic_thumb)
                .showImageForEmptyUri(R.drawable.pic_thumb).showImageOnFail(R.drawable.pic_thumb)
                .cacheInMemory(true).cacheOnDisc(true).build();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(container.getContext());
        photoView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        String imgPath = (String)getItem(position);
        mImageLoader.displayImage(FileUtil.getFormatFilePath(imgPath), (ImageView)photoView,
                mOptions, null);
        // Now just add PhotoView to ViewPager and return it
        container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        return photoView;
    }

    public Object getItem(int position) {
        if (position < mDatas.size()) {
            return mDatas.get(position);
        } else {
            return null;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
