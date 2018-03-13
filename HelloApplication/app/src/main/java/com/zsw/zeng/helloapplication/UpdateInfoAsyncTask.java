package com.zsw.zeng.helloapplication;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 作者：sunnyzeng on 2018/3/6 16:31
 * 描述：
 * Integer 执行AsyncTask时所要传入的参数，可在后台任务中使用
 * Integer 在后台任务执行时，需要在前台页面显示后台任务的进度
 * String 表示的是当任务执行完毕之后，需要对结果进行返回，则使用这里的String作为返回值类型
 */

public class UpdateInfoAsyncTask extends AsyncTask<Integer, Integer, String> {

    private TextView textView;
    private ProgressBar progressBar;

    public UpdateInfoAsyncTask(TextView textView, ProgressBar progressBar) {
        this.textView = textView;
        this.progressBar = progressBar;
    }

    /**
     * 在耗时操作执行之前调用，可以做一些初始化的操作（会经常用来显示一些进度条之类的）
     * 在UI线程中调用的
     */
    @Override
    protected void onPreExecute() {
        textView.setText("开始执行异步线程。。。");
    }


    /**
     * 做耗时操作的（后台计算之类的）
     * @param integers
     * @return 计算的结果（被该函数返回并被传递到onPostExecute方法中）
     */
    @Override
    protected String doInBackground(Integer... integers) {
        int i;
        for (i = 10; i <= 100; i += 10) {
            //发布一个进度单位就可以不断渐变的显示你所执行的后台计算
            publishProgress(i);
        }
        return i + integers[i].intValue() + "";
    }

    /**
     * 通常在doInBackground方法中调用了publishProgress（）之后才会被调用
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];
        progressBar.setProgress(value);
    }

    /**
     * 后台计算完成之后调用
     * @param s
     */
    @Override
    protected void onPostExecute(String s) {
        textView.setText("异步执行操作结束..." + s);
    }
}
