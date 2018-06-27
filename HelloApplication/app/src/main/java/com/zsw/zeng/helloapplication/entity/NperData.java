package com.zsw.zeng.helloapplication.entity;

import java.util.ArrayList;

/**
 * 公司：中望创联
 * 创建时间：2018/6/26
 * 编写人： zengsuwa
 * 功能描述：
 */

public class NperData {
    private String min;
    private String max;
    private ArrayList<String> npers;
    private String parameter;

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public ArrayList<String> getNpers() {
        return npers;
    }

    public void setNpers(ArrayList<String> npers) {
        this.npers = npers;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

}
