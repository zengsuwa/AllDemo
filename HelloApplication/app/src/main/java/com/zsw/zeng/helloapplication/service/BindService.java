package com.zsw.zeng.helloapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 作者：sunnyzeng on 2018/3/1 17:59
 * 描述：
 */

public class BindService extends Service {
    private int count;
    private MyBinder myBinder = new MyBinder();
    private Thread thread;
    private boolean quit = false;

    /**
     * 创建binder对象给客户端即activity使用，提供数据交互的接口
     */
    public class MyBinder extends Binder {
        //声明一个方法，getService(提供给客户端调用)
        public BindService getService(){
            //返回当前对象LocalService，这样我们就可以在客户端调用Service的公共方法了
            return BindService.this;
        }
    }

    /**
     * 把binder类返回给客户端
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    /**
     * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前
     * 如果服务已在运行，则不会调用此方法。
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("BindService", "onCreate()...");
        thread =new Thread(new Runnable() {
            @Override
            public void run() {
                //多线程后台处理
                Log.d("BindService", "多线程后台处理");
                //每个一秒count+1，直到quit=true为止
                while(!quit){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        });
        thread.start();
    }

    /**
     * 每次通过BindService方法启动service都会被回调
     * 如果在Service中执行耗时操作，会发生应用无响应”(ANR) 错误。所以可以在onStartCommand()中执行多线程。
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("BindService", "onStartCommand()...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("BindService", "onUnbind()...");
        return super.onUnbind(intent);
    }

    /**
     * 公共方法
     * @return
     */
    public int getCount(){
        return count;
    }

    /**
     * 服务销毁时回调
     */
    @Override
    public void onDestroy() {

        super.onDestroy();
        quit = true;
        Log.i("BindService", "onDestroy()...");
    }
}
