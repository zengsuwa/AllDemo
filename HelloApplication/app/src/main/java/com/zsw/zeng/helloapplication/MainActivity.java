package com.zsw.zeng.helloapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.zsw.zeng.helloapplication.activity.ActionActivity;
import com.zsw.zeng.helloapplication.activity.AnimationActivity;
import com.zsw.zeng.helloapplication.activity.ApkInfoActivity;
import com.zsw.zeng.helloapplication.activity.PickerViewActivity;
import com.zsw.zeng.helloapplication.activity.SchemeActivity;
import com.zsw.zeng.helloapplication.activity.ServiceTestActivity;
import com.zsw.zeng.helloapplication.activity.SurfaceActivity;
import com.zsw.zeng.helloapplication.banner.BannerActivity;
import com.zsw.zeng.helloapplication.coordinator.CoordinatorActivity;
import com.zsw.zeng.helloapplication.mvp.MvpActivity;
import com.zsw.zeng.helloapplication.noslide.NoSlideActivity;
import com.zsw.zeng.helloapplication.slide.SlideActivity;
import com.zsw.zeng.helloapplication.status.StatusActivity;

/**
 * @author zeng
 * @date 2016/9/5
 * @Description:
 */
public class MainActivity extends Activity {

    private Button noslide;
    private Button isslide;
    private Button status;
    private Button mvp;
    private Button banner;
    private Button selfview;
    private Button coordinator;
    private Button surface;
    private Button animation;
    private Button apkinfo;
    private Button scheme;
    private Button serviceTest;
    private Button actionBtn;
    private Button pickerViewBtn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noslide = (Button) findViewById(R.id.noslide);
        isslide = (Button) findViewById(R.id.isslide);
        status = (Button) findViewById(R.id.status);
        mvp = (Button) findViewById(R.id.mvp);
        banner = (Button) findViewById(R.id.banner);
        selfview = (Button) findViewById(R.id.selfview);
        coordinator = (Button) findViewById(R.id.coordinator);
        surface = (Button) findViewById(R.id.surfaceview);
        animation = (Button) findViewById(R.id.animation);
        apkinfo = (Button) findViewById(R.id.apkinfo);
        scheme = (Button) findViewById(R.id.scheme);
        serviceTest = (Button) findViewById(R.id.servicetest);
        actionBtn = (Button) findViewById(R.id.actionBtn);
        pickerViewBtn = (Button) findViewById(R.id.pickerViewBtn);
        noslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到不滑动的主界面
                intent = new Intent(MainActivity.this, NoSlideActivity.class);
                startActivity(intent);
            }
        });
        isslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到滑动的主界面
                intent = new Intent(MainActivity.this, SlideActivity.class);
                startActivity(intent);
            }
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到沉浸式状态栏
                intent = new Intent(MainActivity.this, StatusActivity.class);
                startActivity(intent);
            }
        });

        mvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到MVP
                intent = new Intent(MainActivity.this, MvpActivity.class);
                startActivity(intent);
            }
        });
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到系统实现沉浸式状态栏
                intent = new Intent(MainActivity.this, BannerActivity.class);
                startActivity(intent);
            }
        });
        selfview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到自定义控件
                intent = new Intent(MainActivity.this, SelfViewActivity.class);
                startActivity(intent);
            }
        });
        coordinator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到自定义控件
                intent = new Intent(MainActivity.this, CoordinatorActivity.class);
                startActivity(intent);
            }
        });
        surface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到Surface
                intent = new Intent(MainActivity.this, SurfaceActivity.class);
                startActivity(intent);
            }
        });
        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到动画框架
                intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });
        apkinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到包信息
                intent = new Intent(MainActivity.this, ApkInfoActivity.class);
                startActivity(intent);
            }
        });
        scheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到scheme跳转协议
                intent = new Intent(MainActivity.this, SchemeActivity.class);
                startActivity(intent);
            }
        });
        serviceTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Service学习
                intent = new Intent(MainActivity.this, ServiceTestActivity.class);
                startActivity(intent);
            }
        });
        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(getApplicationContext(), ActionActivity.class);
                intent.setAction("actionTest");
                startActivity(intent);
            }
        });
        pickerViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(getApplicationContext(), PickerViewActivity.class);
                intent.setAction("actionTest");
                startActivity(intent);
            }
        });

    }
}
