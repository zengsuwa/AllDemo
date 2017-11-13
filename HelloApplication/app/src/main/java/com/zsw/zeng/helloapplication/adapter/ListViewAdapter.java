package com.zsw.zeng.helloapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsw.zeng.helloapplication.R;

import java.util.List;

/**
 * 作者：sunnyzeng on 2017/7/31 16:56
 * 描述：
 */

public class ListViewAdapter extends BaseAdapter {
    private List<String> mData;
    private LayoutInflater mInflater;

    public ListViewAdapter(Context context, List<String> mData) {
        this.mData = mData;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //判断是否缓存
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            //通过LayoutInflater实例化布局
            convertView = mInflater.inflate(R.layout.listview_item, null);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.myImage);
            viewHolder.title = (TextView) convertView.findViewById(R.id.mytitle);
            convertView.setTag(viewHolder);
        }else{
            //通过tag找到缓存的布局
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //设置布局中控件要显示的视图
        viewHolder.img.setBackgroundResource(R.mipmap.ic_launcher);
        viewHolder.title.setText(mData.get(position));
        return convertView;
    }


    public class ViewHolder {
        public ImageView img;
        public TextView title;
    }
}
