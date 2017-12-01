package com.zsw.zeng.helloapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.zsw.zeng.helloapplication.R;
import com.zsw.zeng.helloapplication.entity.AMProcessInfo;

import java.util.ArrayList;
import java.util.List;

public class AMProcessActivity extends AppCompatActivity {

    private ListView amListView;
    private List<AMProcessInfo> aminfo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amprocess);
        amListView = (ListView) findViewById(R.id.amlistview);

    }

    private void getRunningProcessInfo(){
       //TODO 书本217
    }
}
