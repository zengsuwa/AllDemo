package com.zsw.zeng.helloapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsw.zeng.helloapplication.R;
import com.zsw.zeng.helloapplication.entity.PMAppInfo;

import java.util.List;

/**
 * 作者：sunnyzeng on 2017/11/30 15:25
 * 描述：
 */

public class AppInfoListAdapter extends BaseAdapter {
    private List<PMAppInfo> mData;
    private LayoutInflater mInflater;

    public AppInfoListAdapter(List<PMAppInfo> mData, Context context) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
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
        AppInfoViewHolder holder = null;
        if (holder == null) {
            holder = new AppInfoViewHolder();
            //通过LayoutInflater实例化布局
            convertView = mInflater.inflate(R.layout.item_appinfo, null);
            holder.imgIcon = (ImageView) convertView.findViewById(R.id.img_icon);
            holder.label = (TextView) convertView.findViewById(R.id.label);
            holder.packageName = (TextView) convertView.findViewById(R.id.package_name);
            convertView.setTag(holder);
        } else {
            //通过tag找到缓存的布局
            holder = (AppInfoViewHolder) convertView.getTag();
        }

        holder.imgIcon.setImageDrawable(mData.get(position).getAppIcon());
        holder.label.setText(mData.get(position).getAppLable());
        holder.packageName.setText(mData.get(position).getPkgName());

        return convertView;
    }

    public class AppInfoViewHolder {
        public ImageView imgIcon;
        public TextView label;
        public TextView packageName;
    }

}
