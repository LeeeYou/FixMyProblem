package com.example.leeeyou.fixmyproblem.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用Adapter
 *
 * @param <T>
 * @author liyou
 */
public abstract class UniversalAdapter<T> extends BaseAdapter {
    protected final Context context;

    protected List<T> mData;

    protected int layoutId;

    public UniversalAdapter(Context context, List<T> data, int layoutId) {
        super();
        this.context = context;

        mData = new ArrayList<>();
        for (T t : data) {
            mData.add(t);
        }

        this.layoutId = layoutId;
    }

    /**
     * @param context  上下文环境
     * @param data     数组类型的数据
     * @param layoutId 布局文件
     */
    public UniversalAdapter(Context context, T[] data, int layoutId) {
        super();
        this.context = context;
        this.mData = new ArrayList<>();
        for (T t : data) {
            this.mData.add(t);
        }
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        if (mData != null)
            return mData.size();
        return 0;
    }

    @Override
    public T getItem(int position) {
        if (position < mData.size())
            return mData.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = ViewHolder.get(context, convertView, parent, layoutId, position);
        convert(vh, getItem(position), position);
        return vh.getConvertView();
    }

    public abstract void convert(ViewHolder vh, T item, int position);

    public void setData(List<T> data) {
        if (data == null || data.size() == 0) {
            mData = null;
        } else {
            if(mData ==null){
                mData = new ArrayList<>();
            }
            mData.clear();
            mData.addAll(data);
        }

        notifyDataSetChanged();
    }

}
