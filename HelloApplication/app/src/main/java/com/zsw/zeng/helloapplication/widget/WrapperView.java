package com.zsw.zeng.helloapplication.widget;

import android.view.View;

/**
 * 作者：sunnyzeng on 2017/11/28 13:20
 * 描述：属性动画，自定义一个属性类或者包装类，来间接的给这个属性增加get和set方法
 */

public class WrapperView {
    private View mTarget;

    public WrapperView(View mTarget) {
        this.mTarget = mTarget;
    }

    public int getWidth() {
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width) {
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }

}
