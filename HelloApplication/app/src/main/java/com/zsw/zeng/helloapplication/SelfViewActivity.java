package com.zsw.zeng.helloapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zsw.zeng.helloapplication.interfaces.TopBarClickListener;
import com.zsw.zeng.helloapplication.widget.CircleView;
import com.zsw.zeng.helloapplication.widget.MyTopBar;

/**
 * 自定义View
 */
public class SelfViewActivity extends AppCompatActivity {

    private MyTopBar myTopBar;
    private CircleView mCircle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_view);
        myTopBar = (MyTopBar) findViewById(R.id.myTopBar);
        mCircle = (CircleView) findViewById(R.id.arc);

        myTopBar.setOnTopBarClickListener(new TopBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(SelfViewActivity.this, "back", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(SelfViewActivity.this, "more", Toast.LENGTH_SHORT).show();
            }
        });
        mCircle.setProgress(70);

        //左边的显示
//        myTopBar.setButtonVisable(0,true);
        //右边的不显示
//        myTopBar.setButtonVisable(1,false);

    }
}
