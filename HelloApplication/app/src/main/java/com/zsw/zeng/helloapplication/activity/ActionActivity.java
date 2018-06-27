package com.zsw.zeng.helloapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zsw.zeng.helloapplication.R;

/**
 * Created by zwjf on 2018/4/8.
 */

public class ActionActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private String actionName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        actionName = getIntent().getAction();
        Log.e(TAG, "actionName: " + actionName);
    }
}
