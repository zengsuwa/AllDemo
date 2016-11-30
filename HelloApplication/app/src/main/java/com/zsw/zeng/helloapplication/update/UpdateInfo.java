package com.zsw.zeng.helloapplication.update;

/**
 * @author zeng
 * @date 2016/11/29
 * @Description: 查询结果需要解析成 UpdateInfo
 */

public class UpdateInfo {
    // 是否有新版本
    public boolean hasUpdate = false;
    // 是否静默下载：有新版本时不提示直接下载，下次启动时安装
    public boolean isSilent = false;
    // 是否强制安装：不安装无法使用app
    public boolean isForce = false;
    // 是否可忽略该版本
    public boolean isIgnorable = true;
    // 是否是增量补丁包，暂不支持
    public boolean isPatch = false;

    public int versionCode;
    public String versionName;
    public String updateContent;

    public String url;
    public String md5;
    public long size;

    public String patchUrl;
    public String patchMd5;
    public long patchSize;
}
