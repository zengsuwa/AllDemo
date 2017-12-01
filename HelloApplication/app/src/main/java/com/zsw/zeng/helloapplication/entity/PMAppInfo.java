package com.zsw.zeng.helloapplication.entity;

import android.graphics.drawable.Drawable;

/**
 * 作者：sunnyzeng on 2017/11/30 13:17
 * 描述：应用信息
 */

public class PMAppInfo {
    /** 应用名称 */
    private String appLable;
    /** 应用图标 */
    private Drawable appIcon;
    /** 应用包名 */
    private String pkgName;

    public PMAppInfo() {
    }

    public String getAppLable() {
        return appLable;
    }

    public void setAppLable(String appLable) {
        this.appLable = appLable;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }
}
