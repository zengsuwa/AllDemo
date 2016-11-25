package com.zsw.zeng.helloapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zsw.zeng.helloapplication.noslide.NoSlideActivity;
import com.zsw.zeng.helloapplication.slide.SlideActivity;
import com.zsw.zeng.helloapplication.status.SecondStatusActivity;
import com.zsw.zeng.helloapplication.status.SystemStatusActivity;
import com.zsw.zeng.helloapplication.status.ThirdStatusActivity;

/**
 * @author zeng
 * @date 2016/9/5
 * @Description:
 */
public class MainActivity extends Activity {

    private Button noslide;
    private Button isslide;
    private Button systemStatus;
    private Button secondStatus;
    private Button thirdStatus;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noslide = (Button) findViewById(R.id.noslide);
        isslide = (Button) findViewById(R.id.isslide);
        systemStatus = (Button) findViewById(R.id.system_status);
        secondStatus = (Button) findViewById(R.id.second_status);
        thirdStatus = (Button) findViewById(R.id.third_status);
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
        systemStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到系统实现沉浸式状态栏
                intent = new Intent(MainActivity.this, SystemStatusActivity.class);
                startActivity(intent);
            }
        });
        secondStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到系统实现沉浸式状态栏
                intent = new Intent(MainActivity.this, SecondStatusActivity.class);
                startActivity(intent);
            }
        });
        thirdStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到系统实现沉浸式状态栏
                intent = new Intent(MainActivity.this, ThirdStatusActivity.class);
                startActivity(intent);
            }
        });
    }
}
