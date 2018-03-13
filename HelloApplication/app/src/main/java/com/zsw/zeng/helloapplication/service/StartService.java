package com.zsw.zeng.helloapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 作者：sunnyzeng on 2018/3/1 14:49
 * 描述：
 */

public class StartService extends Service {
    /**
     * 绑定服务时才会调用
     * 必须要实现的方法
     *
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前
     * 如果服务已在运行，则不会调用此方法。
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("StartService", "onCreate()...");
        Log.d("StartService", "Service Thread id is " + Thread.currentThread().getId());
    }

    /**
     * 每次通过startService方法启动service都会被回调
     * 如果在Service中执行耗时操作，会发生应用无响应”(ANR) 错误。所以可以在onStartCommand()中执行多线程。
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("StartService", "onStartCommand()...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //多线程后台处理
                Log.d("StartService", "多线程后台处理");
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 服务销毁时回调
     */
    @Override
    public void onDestroy() {

        super.onDestroy();
        Log.d("StartService", "onDestroy()...");
    }
}
