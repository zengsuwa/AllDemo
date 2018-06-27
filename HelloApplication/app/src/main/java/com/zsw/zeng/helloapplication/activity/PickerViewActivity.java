package com.zsw.zeng.helloapplication.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.zsw.zeng.helloapplication.R;
import com.zsw.zeng.helloapplication.entity.AmountData;
import com.zsw.zeng.helloapplication.entity.NperData;
import com.zsw.zeng.helloapplication.entity.ProvinceBean;

import java.util.ArrayList;
import java.util.List;

public class PickerViewActivity extends AppCompatActivity {

    private Button btnPicker;
    private OptionsPickerView pvOptions;
    private ArrayList<AmountData> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private int defaultOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_view);
        initData();
        btnPicker = (Button) findViewById(R.id.btn_picker);
        initPickerView();
        btnPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvOptions.show();
            }
        });
    }

    private void initData() {
        List<NperData> nperDataList = new ArrayList<>();

        NperData nperData = new NperData();
        nperData.setMin("3000");
        nperData.setMax("5000");
        ArrayList<String> stringList1 = new ArrayList<>();
        stringList1.add("3");
        nperData.setNpers(stringList1);
        nperDataList.add(nperData);

        NperData nperData2 = new NperData();
        nperData2.setMin("5000");
        nperData2.setMax("9000");
        ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add("3");
        stringList2.add("6");
        nperData2.setNpers(stringList2);
        nperDataList.add(nperData2);

        NperData nperData3 = new NperData();
        nperData3.setMin("9000");
        nperData3.setMax("*");
        ArrayList<String> stringList3 = new ArrayList<>();
        stringList3.add("6");
        stringList3.add("9");
        stringList3.add("12");
        nperData3.setNpers(stringList3);
        nperDataList.add(nperData3);

        //选项1
        int min = 3000;
        int max = 200000;
        for (int i = min; i <= max; i = i + 1000) {
//            options1Items.add(new ProvinceBean(0, i + "", "描述部分", "其他数据"));
            //选项1
            options1Items.add(new AmountData(i));
            for (int j = 0; j < nperDataList.size(); j++) {
                NperData tempData = nperDataList.get(j);
                int minAmt = Integer.valueOf(tempData.getMin());
                int maxAmt = 0;
                if ("*".equals(tempData.getMax())) {
                    maxAmt = Integer.MAX_VALUE;
                } else {
                    maxAmt = Integer.valueOf(tempData.getMax());
                }
                if (i >= minAmt && i < maxAmt) {
                    //选项2
                    options2Items.add(tempData.getNpers());
                    break;
                }
            }
        }
        defaultOption = options1Items.size();
//        options1Items.add(new ProvinceBean(0, "广东", "描述部分", "其他数据"));
//        options1Items.add(new ProvinceBean(1, "湖南", "描述部分", "其他数据"));
//        options1Items.add(new ProvinceBean(2, "广西", "描述部分", "其他数据"));
        //选项2
//        ArrayList<String> options2Items_01 = new ArrayList<>();
//        options2Items_01.add("广州");
//        options2Items_01.add("佛山");
//        options2Items_01.add("东莞");
//        options2Items_01.add("珠海");
//        ArrayList<String> options2Items_02 = new ArrayList<>();
//        options2Items_02.add("长沙");
//        options2Items_02.add("岳阳");
//        options2Items_02.add("株洲");
//        options2Items_02.add("衡阳");
//        ArrayList<String> options2Items_03 = new ArrayList<>();
//        options2Items_03.add("桂林");
//        options2Items_03.add("玉林");
//        options2Items.add(options2Items_01);
//        options2Items.add(options2Items_02);
//        options2Items.add(options2Items_03);
    }

    private void initPickerView() {
        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()
                        + options2Items.get(options1).get(options2)
                       /* + options3Items.get(options1).get(options2).get(options3).getPickerViewText()*/;
                btnPicker.setText(tx);
            }
        })
                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .setSelectOptions(defaultOption - 1, 0)//默认选中项
                .build();
//                .setTitleText("城市选择")
//                .setContentTextSize(20)//设置滚轮文字大小
//                .setDividerColor(Color.LTGRAY)//设置分割线的颜色
//                .setSelectOptions(0, 1)//默认选中项
//                .setBgColor(Color.WHITE)
//                .setTitleBgColor(Color.DKGRAY)
//                .setTitleColor(Color.LTGRAY)
//                .setCancelColor(Color.BLUE)
//                .setSubmitColor(Color.BLUE)
//                .setTextColorCenter(Color.LTGRAY)
//                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
//                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                .setLabels("省", "市", "区")
//                .setBackgroundId(0x00000000) //设置外部遮罩颜色
//                .setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
//                    @Override
//                    public void onOptionsSelectChanged(int options1, int options2, int options3) {
//                        String str = "options1: " + options1 + "\noptions2: " + options2 + "\noptions3: " + options3;
//                        Toast.makeText(PickerViewActivity.this, str, Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .build();

//        pvOptions.setSelectOptions(1,1);
        /*pvOptions.setPicker(options1Items);//一级选择器*/
        pvOptions.setPicker(options1Items, options2Items);//二级选择器
        /*pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器*/
    }
}
