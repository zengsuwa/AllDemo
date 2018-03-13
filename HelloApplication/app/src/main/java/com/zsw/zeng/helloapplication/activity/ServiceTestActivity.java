package com.zsw.zeng.helloapplication.activity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zsw.zeng.helloapplication.R;
import com.zsw.zeng.helloapplication.service.BindService;
import com.zsw.zeng.helloapplication.service.StartService;

import java.util.zip.InflaterInputStream;

public class ServiceTestActivity extends AppCompatActivity {

    private Button start;
    private Button stop;
    private Button bind;
    private Button unbind;
    private Button getSdata;
    /**
     * ServiceConnection代表与服务的连接，他只有两个方法
     * onServiceConnected和onServiceDisconnected
     * 前者是在操作者连接一个服务成功时被调用，而后者是在服务崩溃或被杀死导致的连接中断时被调用
     */
    private ServiceConnection connection;
    private BindService mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        start = (Button) findViewById(R.id.startService);
        stop = (Button) findViewById(R.id.stopService);
        bind = (Button) findViewById(R.id.bindService);
        unbind = (Button) findViewById(R.id.unbindService);
        getSdata = (Button) findViewById(R.id.getServiceData);

        Log.d("ServiceTestActivity","ServiceTestActivity thread id is "+Thread.currentThread().getId());
        final Intent intent = new Intent(ServiceTestActivity.this, StartService.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        final Intent bindIntent = new Intent(this,BindService.class);

        //开启绑定
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ServiceTestActivity","绑定调用：bindService");
                //调用绑定方法
                bindService(bindIntent,connection, Service.BIND_AUTO_CREATE);
            }
        });
        //解除绑定
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ServiceTestActivity","解除绑定调用：unbindService");
                if(mService!=null){
                    mService = null;
                    unbindService(connection);
                }
            }
        });

        //获取数据
        getSdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mService!=null){
                    //通过绑定服务传递Binder对象，获取Service暴露出来的数据
                    Log.d("ServiceTestActivity","从服务端获取数据："+mService.getCount());
                }else{
                    Log.d("ServiceTestActivity","还没绑定呢，先绑定无法从服务端获取数据。");
                }
            }
        });

        connection = new ServiceConnection() {
            /**
             * 与服务器端交互的接口方法 绑定服务时候被回调，在这个方法获取绑定Service传递过来的IBinder对象
             * 通过这个IBinder对象，实现宿主和Service
             * @param name
             * @param service
             */
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("ServiceTestActivity","绑定成功调用：onServiceConnected");
                //获取binder
                BindService.MyBinder binder = (BindService.MyBinder) service;
                mService = binder.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
             mService=null;
            }
        };

    }
}
