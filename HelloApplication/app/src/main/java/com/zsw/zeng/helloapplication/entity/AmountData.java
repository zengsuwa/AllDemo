package com.zsw.zeng.helloapplication.entity;

import com.contrarywind.interfaces.IPickerViewData;

/**
 * 公司：中望创联
 * 创建时间：2018/6/27
 * 编写人： zengsuwa
 * 功能描述：
 */

public class AmountData implements IPickerViewData {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public AmountData(int amount) {
        this.amount = amount;
    }

    @Override
    public String getPickerViewText() {
        return String.valueOf(amount);
    }
}
