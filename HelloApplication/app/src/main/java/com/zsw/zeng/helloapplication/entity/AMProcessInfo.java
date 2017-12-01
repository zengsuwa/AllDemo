package com.zsw.zeng.helloapplication.entity;

/**
 * 作者：sunnyzeng on 2017/12/1 13:40
 * 描述：
 */

public class AMProcessInfo {
    private String pid;
    private String uid;
    private String memorySize;
    private String processName;

    public AMProcessInfo() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
