package com.zsw.zeng.helloapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * 作者：sunnyzeng on 2018/3/7 13:38
 * 描述：
 */

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     * MyIntentService表示他的线程名称
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * 实现异步任务的方法
     * @param intent Activity 传递过来的intent，数据封装在intent中
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
