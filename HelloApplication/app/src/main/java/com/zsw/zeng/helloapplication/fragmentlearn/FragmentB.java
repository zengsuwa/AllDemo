package com.zsw.zeng.helloapplication.fragmentlearn;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsw.zeng.helloapplication.R;


/**
 * 作者：sunnyzeng on 2017/11/10 11:49
 * 描述：
 * 静态的使用Fragment
 * <p>
 * 继承Fragment，重写onCreateView决定Fragment的布局
 * 在Activity中声明此Fragment,就和普通的View一样
 * <p>
 * Fragment常用的API
 * <p>
 * android.support.v4.app.Fragment 主要用于定义Fragment
 * android.support.v4.app.FragmentManager 主要用于在Activity中操作Fragment，
 * 可以使用FragmentManager.findFragmenById，FragmentManager.findFragmentByTag等方法去找到一个Fragment
 * android.support.v4.app.FragmentTransaction 保证一些列Fragment操作的原子性，熟悉事务这个词
 * 主要的操作都是FragmentTransaction的方法 (一般我们为了向下兼容，都使用support.v4包里面的Fragment)
 * getFragmentManager() // Fragment若使用的是support.v4包中的，那就使用getSupportFragmentManager代替
 */

public class FragmentB extends Fragment {
    /**
     * Fragment中保存变量的代码
     **/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("FragmentB:", "onCreateView");
        if (null != savedInstanceState) {
            savedInstanceState.getString("string");
            //得到保存下来的string
        }
        View root = inflater.inflate(R.layout.fragment_he, null);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("string", "anAngryAnt");
        super.onSaveInstanceState(outState);
    }
}
