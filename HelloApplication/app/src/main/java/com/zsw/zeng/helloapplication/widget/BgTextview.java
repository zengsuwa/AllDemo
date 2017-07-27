package com.zsw.zeng.helloapplication.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zengsuwa on 2017/7/21.
 * 带背景的textview
 * 绘制两个不同大小的举行,形成一个重叠效果,再绘制文字
 */
public class BgTextview extends TextView{
    private Paint mPaint1;
    private Paint mPaint2;


    public BgTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(getResources().getColor(android.R.color.holo_orange_light));
        mPaint2.setStyle(Paint.Style.FILL);
    }

    /**
     * 原生的TextView使用OnDraw方法绘制要显示的文字,当继承了系统的TextView之后,
     * 如果不重写其onDraw方法,则不会修改TextView的任何效果,可以认为在自定义的TextView中
     * 调用TextView的OnDraw方法来绘制文字
     * 程序调用super.onDraw(canvas)来实现原生控件的功能,但是在调用super.onDraw(canvas)
     * 方法之前和之后我们都可以实现自己的逻辑,分别在系统绘制前后完成自己的操作
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {


        //绘制外层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);

        //绘制内层矩形
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);

        canvas.save();

        //绘制文字前平移10像素
        canvas.translate(10,0);
        //父类完成的方法,即绘制文本
        //在回调父类方法前,实现自己的逻辑,对TextView来说即是在绘制文本内容前
        super.onDraw(canvas);
        //在回调父类方法后,实现自己的逻辑,对TextView来说即是在绘制文本内容后
        canvas.restore();

    }
}
