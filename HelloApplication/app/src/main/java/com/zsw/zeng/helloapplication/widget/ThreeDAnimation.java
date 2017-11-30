package com.zsw.zeng.helloapplication.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

/**
 * 作者：sunnyzeng on 2017/11/28 18:01
 * 描述：
 */

public class ThreeDAnimation extends Animation {
    private int mCenterWidth;
    private int mCenterHeight;
    private Camera mCamera = new Camera();
    private float mRotateY = 0.0f;


    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        //设置默认时长 设置默认持续时间
        setDuration(2000);
        //动画结束后保留状态
        setFillAfter(true);
        //设置默认插值器
        setInterpolator(new BounceInterpolator());
        //保存View的中心点
        mCenterWidth = width / 2;
        mCenterHeight = height / 2;
    }

    //暴露接口，设置旋转角度
    public void setRotateY(float rotateY){
        mRotateY=rotateY;
    }


    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        //获得Transformation的Matrix
        final Matrix matrix = t.getMatrix();
        //保存当前镜头状态
        mCamera.save();
        //使用Camera设置旋转的角度 使相机旋转
        mCamera.rotateY(mRotateY * interpolatedTime);
        //将旋转变换作用到matrix上
        mCamera.getMatrix(matrix);
        //合并镜头层
        mCamera.restore();
        //通过pre方法设置矩阵作用钱的偏移量来改变旋转中心
        //操作前平移
        matrix.preTranslate(mCenterWidth, mCenterHeight);
        //操作后平移
        matrix.postTranslate(-mCenterWidth, -mCenterHeight);

    }
}
