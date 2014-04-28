/**
 * ImageGroupAdapter.java
 * ImageChooser
 * 
 * Created by likebamboo on 2014-4-22
 * Copyright (c) 1998-2014 http://likebamboo.github.io/ All rights reserved.
 */

package com.likebamboo.imagechooser.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.likebamboo.imagechooser.R;
import com.likebamboo.imagechooser.loader.LocalImageLoader;
import com.likebamboo.imagechooser.loader.LocalImageLoader.ImageCallBack;
import com.likebamboo.imagechooser.model.ImageGroup;
import com.likebamboo.imagechooser.widget.MyImageView;

import java.util.List;

/**
 * 分组图片适配器
 * 
 * @author likebamboo
 */
public class ImageGroupAdapter extends BaseAdapter {
    /**
     * 上下文对象
     */
    private Context mContext = null;

    /**
     * 图片列表
     */
    private List<ImageGroup> mDataList = null;

    /**
     * 容器
     */
    private View mContainer = null;

    public ImageGroupAdapter(Context context, List<ImageGroup> list, View container) {
        mDataList = list;
        mContext = context;
        mContainer = container;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public ImageGroup getItem(int position) {
        if (position < 0 || position > mDataList.size()) {
            return null;
        }
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.image_group_item, null);
            holder.mImageIv = (MyImageView)view.findViewById(R.id.group_item_image_iv);
            holder.mTitleTv = (TextView)view.findViewById(R.id.group_item_title_tv);
            holder.mCountTv = (TextView)view.findViewById(R.id.group_item_count_tv);

            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }

        ImageGroup item = getItem(position);
        if (item != null) {
            // 图片路径
            String path = item.getFirstImgPath();
            // 标题
            holder.mTitleTv.setText(item.getDirName());
            // 计数
            holder.mCountTv.setText(mContext.getString(R.string.image_count, item.getImageCount()));
            holder.mImageIv.setTag(path);
            // 加载图片
            // 利用NativeImageLoader类加载本地图片
            Bitmap bitmap = LocalImageLoader.getInstance().loadImage(path,
                    holder.mImageIv.getPoint(), new ImageCallBack() {
                        @Override
                        public void onImageLoader(Bitmap bitmap, String path) {
                            ImageView mImageView = (ImageView)mContainer.findViewWithTag(path);
                            if (bitmap != null && mImageView != null) {
                                mImageView.setImageBitmap(bitmap);
                            }
                        }
                    });
            if (bitmap != null) {
                holder.mImageIv.setImageBitmap(bitmap);
            } else {
                holder.mImageIv.setImageResource(R.drawable.pic_thumb);
            }
        }
        return view;
    }

    static class ViewHolder {
        public MyImageView mImageIv;

        public TextView mTitleTv;

        public TextView mCountTv;
    }

}
