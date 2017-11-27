package com.zsw.zeng.helloapplication.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 作者：sunnyzeng on 2017/11/23 16:38
 * 描述：绘制正弦曲线
 *
 * View通过刷新来重绘视图，Android系统通过发出VSYNC信号来进行屏幕的重绘，
 * 刷新的间隔时间为16ms。如果在16ms内View完成了所需要执行的所有操作，
 * 那么在用户的视觉上，就不会产生卡顿的感觉；而如果执行的操作逻辑太多，
 * 特别是需要频繁刷新的界面上，例如游戏界面，那么就会不断阻塞主线程，从而导致画面卡顿。
 *
 * 为了避免这一问题的产生，Android系统提供了SurfaceView组件来解决这个问题。SurfaceView可以说是View的孪生兄弟，但它与View还是有所不同，它们的区别主要体现在以下几点。
 * View主要适用于主动更新的情况下，而SurfaceView主要适用于被动更新，例如频繁地刷新。
 * View在主线程中对画面进行刷新，而SurfaceView通常会通过一个子线程来进行页面的刷新。
 * View在绘图时没有使用双缓冲机制，而SurfaceView在底层实现机制中就已经实现了双缓冲机制。
 * 总之，如果你的自定义View需要频繁刷新，或者刷新时数据处理量比较大，那么你就可以考虑使用SurfaceView来取代View了。
 *
 */

public class SurfaceViewTemplate extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    //SurfaceHolder
    private SurfaceHolder mHolder;
    //用于绘图的Canvas
    private Canvas mCanvas;
    //子线程的标志位
    private boolean mIsDrawing;

    //画得点的x,y轴
    private int x, y;
    //路径记录
    private Path mPath;
    //画笔
    private Paint mPaint;


    public SurfaceViewTemplate(Context context) {
        super(context);
        initViews();
    }

    public SurfaceViewTemplate(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public SurfaceViewTemplate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        mHolder = getHolder();


        mPath = new Path();
        mPaint = new Paint();
        mHolder.addCallback(this);

        //设置paint的属性
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        //mHolder.setFormat(PixelFormat.OPAQUE);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        while (mIsDrawing) {
            draw();
            //正弦曲线
            x += 1;
            y = (int) (100 * Math.sin(x * 2 * Math.PI / 180) + 400);
            mPath.lineTo(x,y);
        }
    }

    private void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            //画图
            //SurfaceView 背景图
            mCanvas.drawColor(Color.WHITE);
            mCanvas.drawPath(mPath,mPaint);
        } catch (Exception e) {

        }
        finally {
            if (mCanvas != null) {
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }
}
