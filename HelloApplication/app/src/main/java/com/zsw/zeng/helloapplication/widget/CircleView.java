package com.zsw.zeng.helloapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zsw.zeng.helloapplication.R;

/**
 * 作者：sunnyzeng on 2017/7/28 14:28
 * 描述：重写View 弧线展示图
 */

public class CircleView extends View {
    // 中心圆的xy轴坐标
    private float mCircleXY;
    // 中心圆的半径
    private float mRadius;
    // 中心圆的画笔
    private Paint mCirclePaint;
    // 弧线椭圆的画笔
    private Paint mArcPaint;
    // 弧线扫过的角度
    private float mSweepValue;
    // 中心圆的文字
    private String mShowText;
    // 文字的画笔
    private Paint mTextPaint;
    // 画布的宽
    private int length;
    // 文字大小尺寸
    private float mShowTextSize;
    /* 属性 */
    private TypedArray ta;

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ta = context.obtainStyledAttributes(attrs, R.styleable.CircleView);

        //给中心圆设置属性
        mCirclePaint = new Paint();
        //设置画笔颜色
        mCirclePaint.setColor(ta.getColor(R.styleable.CircleView_centerCircleColor, 0));

        //给圆弧设置属性
        mArcPaint = new Paint();
        //设置画笔颜色
        mArcPaint.setColor(ta.getColor(R.styleable.CircleView_arcColor, 0));
        //设置画笔为空心
        mArcPaint.setStyle(Paint.Style.STROKE);
        //设置线宽
        mArcPaint.setStrokeWidth(ta.getInteger(R.styleable.CircleView_arcWidth, 60));
        setProgress(ta.getFloat(R.styleable.CircleView_arcAngle, 10));

        //给中间文字设置属性
        mTextPaint = new Paint();
        //设置字体颜色
        mTextPaint.setColor(ta.getColor(R.styleable.CircleView_centerTextColor, 0));
        //设置字体大小
        mShowTextSize = ta.getDimension(R.styleable.CircleView_centerFontSize, 10);
        mTextPaint.setTextSize(mShowTextSize);

        ta.recycle();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //长度根据字体长度改变
        length = w;
        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //弧线椭圆的外接矩形
        RectF mArcRectF;
        // 绘制弧形的外接矩形属性
        mArcRectF = new RectF(
                (float) (length * 0.1),
                (float) (length * 0.1),
                (float) (length * 0.9),
                (float) (length * 0.9)
        );
        // 绘制中心圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        // 绘制弧形
        canvas.drawArc(mArcRectF, 270, mSweepValue, false, mArcPaint);
        // 绘制文字
        // 测量字体宽度，根据字体的宽度设置在圆环中间
        float textWidth = mTextPaint.measureText(mShowText);
        // 通过文字的大小和长度将文字绘制在圆的正中心
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY - (textWidth / 2), mCircleXY + (mShowTextSize / 4), mTextPaint);

    }


    /**
     * 给弧形设置一个角度（百分比的形式）
     *
     * @param mSweepValue 角度比例
     */
    public void setProgress(float mSweepValue) {
        if (mSweepValue != 0) {
            this.mSweepValue = (float) (360.0 * (mSweepValue / 100.0));
            mShowText = mSweepValue + "%";
        } else {
            this.mSweepValue = 25;
            mShowText = 25 + "%";
        }

        invalidate();
    }
}
