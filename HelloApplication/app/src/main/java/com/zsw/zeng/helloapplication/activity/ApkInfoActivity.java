package com.zsw.zeng.helloapplication.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.zsw.zeng.helloapplication.R;
import com.zsw.zeng.helloapplication.adapter.AppInfoListAdapter;
import com.zsw.zeng.helloapplication.entity.PMAppInfo;

import java.util.ArrayList;
import java.util.List;

public class ApkInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int ALL_APP = 1;
    private static final int SYSTEM_APP = 2;
    private static final int THIRD_APP = 3;
    private static final int SDCARD_APP = 4;
    private Button all;
    private Button system;
    private Button rd;
    private Button sdcard;
    private ListView myListView;
    private PackageManager pm;
    //这个写在全局，不写在getAppInfo方法里，不然每次都new了一个新的list出来，就相当于new了一个新的数据源来，所以原来的根本就没有改变，再notify是没有效果的
    private List<PMAppInfo> appInfos = new ArrayList<>();//已安装的app集合
    private AppInfoListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apk_info);
        intiView();
    }

    private void intiView() {
        all = (Button) findViewById(R.id.all);
        system = (Button) findViewById(R.id.system);
        rd = (Button) findViewById(R.id.rd);
        sdcard = (Button) findViewById(R.id.sdcard);
        myListView = (ListView) findViewById(R.id.mylist);

        all.setOnClickListener(this);
        system.setOnClickListener(this);
        rd.setOnClickListener(this);
        sdcard.setOnClickListener(this);

    }

    private void getAppInfo(int flag) {
        //获取PackageManager对象
        pm = this.getPackageManager();
        //获取应用信息
        List<ApplicationInfo> listApplications = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);

        //判断应用类型
        switch (flag) {
            case ALL_APP:
                appInfos.clear();

                for (ApplicationInfo app : listApplications) {
                    appInfos.add(makeAppInfo(app));
                }
                break;
            case SYSTEM_APP:
                appInfos.clear();

                for (ApplicationInfo app : listApplications) {
                    if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                        appInfos.add(makeAppInfo(app));
                    }
                }
                break;
            case THIRD_APP:
                appInfos.clear();

                for (ApplicationInfo app : listApplications) {
                    if ((app.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
                        appInfos.add(makeAppInfo(app));
                    } else if ((app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                        appInfos.add(makeAppInfo(app));
                    }
                }
                break;
            case SDCARD_APP:
                appInfos.clear();

                for (ApplicationInfo app : listApplications) {
                    if ((app.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) != 0) {
                        appInfos.add(makeAppInfo(app));
                    }
                }
                break;

        }

    }

    private PMAppInfo makeAppInfo(ApplicationInfo app) {
        PMAppInfo appInfo = new PMAppInfo();
        appInfo.setAppLable((String) app.loadLabel(pm));
        appInfo.setAppIcon(app.loadIcon(pm));
        appInfo.setPkgName(app.packageName);
        return appInfo;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.all:
                getAppInfo(ALL_APP);
                break;
            case R.id.system:
                getAppInfo(SYSTEM_APP);
                break;
            case R.id.rd:
                getAppInfo(THIRD_APP);
                break;
            case R.id.sdcard:
                getAppInfo(SDCARD_APP);
                break;
        }

        if (adapter == null) {
            adapter = new AppInfoListAdapter(appInfos, this);
        } else {
            adapter.notifyDataSetChanged();
        }
        myListView.setAdapter(adapter);
    }
}
