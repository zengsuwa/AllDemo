package com.zsw.zeng.helloapplication.coordinator;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zsw.zeng.helloapplication.R;

/**
 * CoordinatorLayout，它是一个 FrameLayout
 * 该布局的强大在于，能够协调子元素之间的依赖关系。
 * 详解：https://www.cnblogs.com/wchhuangya/p/6056174.html
 *
 */
public class CoordinatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Hello Snackbar",Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
