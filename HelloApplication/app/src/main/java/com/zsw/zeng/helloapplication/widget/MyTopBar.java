package com.zsw.zeng.helloapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsw.zeng.helloapplication.R;
import com.zsw.zeng.helloapplication.interfaces.TopBarClickListener;

/**
 * 作者：sunnyzeng on 2017/7/27 17:15
 * 描述：
 */

public class MyTopBar extends RelativeLayout {

    private TextView mTitleView;
    private Button mLeftButton;
    private Button mRightButton;

    private String mTitle;
    private int mTitleTextColor;
    private float mTitleTextSize;

    private String mLeftText;
    private int mLeftTextColor;
    private Drawable mLeftBackground;

    private String mRightText;
    private int mRightTextColor;
    private Drawable mRightBackground;

    private LayoutParams mLeftLayoutParams;
    private LayoutParams mRightLayoutParams;
    private LayoutParams mTitleLayoutParams;

    private TopBarClickListener topBarClickListener;

    public void setOnTopBarClickListener(TopBarClickListener topBarClickListener) {
        this.topBarClickListener = topBarClickListener;
    }

    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTitleView = new TextView(context);
        mLeftButton = new Button(context);
        mRightButton = new Button(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        //获取属性
        mTitle = typedArray.getString(R.styleable.TopBar_mytitle);
        mTitleTextColor = typedArray.getColor(R.styleable.TopBar_mytitleTextColor, 0);
        mTitleTextSize = typedArray.getDimension(R.styleable.TopBar_mytitleTextSize, 10);

        mLeftText = typedArray.getString(R.styleable.TopBar_leftText);
        mLeftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);

        mRightText = typedArray.getString(R.styleable.TopBar_rightText);
        mRightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);

        //获取完TypedArray的值后，一般要调用来完成资源的回收
        typedArray.recycle();

        //设置内容和样式
        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftButton.setText(mLeftText);
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);

        mRightButton.setText(mRightText);
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);

        //设置位置
        mLeftLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mLeftLayoutParams.addRule(ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftButton,mLeftLayoutParams);

        mRightLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRightLayoutParams.addRule(ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightLayoutParams);

        mTitleLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mTitleLayoutParams.addRule(CENTER_IN_PARENT,TRUE);
        addView(mTitleView,mTitleLayoutParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topBarClickListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topBarClickListener.rightClick();
            }
        });

    }

    /**
     * 设置按钮的显示是否通过ID区分按钮，flag区分是否显示
     * @param id
     * @param flag 是否显示
     */
    public void setButtonVisable(int id,boolean flag){
        if(flag){
            if(id == 0){
                mLeftButton.setVisibility(VISIBLE);
            }else{
                mRightButton.setVisibility(VISIBLE);
            }
        }else{
            if(id == 0){
                mLeftButton.setVisibility(GONE);
            }else{
                mRightButton.setVisibility(GONE);
            }
        }
    }

}
