package com.zsw.zeng.helloapplication.update;

import android.app.Activity;
import android.os.Bundle;

import com.zsw.zeng.helloapplication.R;

import ezy.boost.update.UpdateManager;

/**
 * @author zeng
 * @date 2016/11/29
 * @Description:
 */

public class UpdateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        // 设置默认更新接口地址与渠道
        //UpdateManager.setUrl(mCheckUrl, "yyb");
        //进入应用时检查更新
//        UpdateManager.check(this);
        // 在设置界面点击检查更新
//        UpdateManager.checkManual(this);
//        可以定制解析过程
//
//        UpdateManager.create(this).setUrl(mCheckUrl).setParser(new UpdateAgent.InfoParser() {
//            @Override
//            public UpdateInfo parse(String source) throws Exception {
//                UpdateInfo info = new UpdateInfo();
//                // todo
//                return info;
//            }
//        }).check();
//        更新版本对话框
//
//        UpdateManager.create(this).setOnPrompt(new UpdateAgent.OnPromptListener() {
//            @Override
//            public void onPrompt(UpdateAgent agent) {
//                // todo : 根据 agent.getInfo() 显示更新版本对话框，具体可参考 UpdateAgent.OnPrompt
//            }
//        }).check();
//        没有新版本或出错
//
//        UpdateManager.create(this).setOnFailure(new UpdateAgent.OnFailureListener() {
//            @Override
//            public void onFailure(UpdateError error) {
//                Toast.makeText(mContext, error.toString(), Toast.LENGTH_LONG).show();
//            }
//        }).check();
//        显示下载进度
//
//        可在通知栏显示下载进度，当 info.isSilent 为 true 显示
//
//                默认通知栏进度
//
//        UpdateManager.create(this).setNotifyId(998).check();
//        定制通知栏进度
//
//        UpdateManager.create(this).setOnNotify(new UpdateAgent.OnProgressListener() {
//            @Override
//            public void onStart() {
//                // todo: start
//            }
//
//            @Override
//            public void onProgress(int progress) {
//                // todo: progress
//            }
//
//            @Override
//            public void onFinish() {
//                // todo: finish
//            }
//        }).check();
//        定制下载进度的对话框，当 info.isSilent 为 false 显示
//
//        UpdateManager.create(this).setOnProgress(new UpdateAgent.OnProgressListener() {
//            @Override
//            public void onStart() {
//                // todo: start
//            }
//
//            @Override
//            public void onProgress(int progress) {
//                // todo: progress
//            }
//
//            @Override
//            public void onFinish() {
//                // todo: finish
//            }
//        }).check();
//
    }
}
