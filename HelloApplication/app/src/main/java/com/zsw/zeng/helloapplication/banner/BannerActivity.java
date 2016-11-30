package com.zsw.zeng.helloapplication.banner;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zsw.zeng.helloapplication.R;
import com.zsw.zeng.helloapplication.banner.transformer.AlphaPageTransformer;
import com.zsw.zeng.helloapplication.banner.transformer.NonPageTransformer;
import com.zsw.zeng.helloapplication.banner.transformer.RotateDownPageTransformer;
import com.zsw.zeng.helloapplication.banner.transformer.RotateUpPageTransformer;
import com.zsw.zeng.helloapplication.banner.transformer.RotateYTransformer;
import com.zsw.zeng.helloapplication.banner.transformer.ScaleInTransformer;

import java.util.ArrayList;

/**
 * @author zeng
 * @date 2016/11/30
 * @Description:
 */

public class BannerActivity extends Activity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private LinearLayout pointGroup;
    //用list对图片资源进行包装
    private ArrayList<ImageView> imageList;
    /**
     * 上一个页面的位置
     */
    protected int lastPosition;

    int[] imgRes = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,R.drawable.i};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pointGroup = (LinearLayout) findViewById(R.id.point_group);
        //初始化图片资源
        imageList = new ArrayList<ImageView>();
        for (int i = 0; i < imgRes.length; i++) {
            ImageView imageView = new ImageView(BannerActivity.this);
            imageView.setImageResource(imgRes[i]);
            imageList.add(imageView);
            View point = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            params.rightMargin = 20;
            params.bottomMargin = 5;
            point.setLayoutParams(params);
            point.setBackgroundResource(R.drawable.point_bg);
            if (i == 0) {
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }

            pointGroup.addView(point);
        }
        //设置page间隔
        viewPager.setPageMargin(40);
        //设置页面缓存数
        viewPager.setOffscreenPageLimit(3);

        viewPager.setAdapter(pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Log.e("qqq","position="+position);
                position = position % imageList.size();
                Log.e("qqq","position % ===="+position);
                container.addView(imageList.get(position));
                return imageList.get(position);
            }

            //写这个不然会报错
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
                object = null ;
            }
        });
        //没有动画效果 平行滑动
//        viewPager.setPageTransformer(true, new NonPageTransformer());
        //带透明度的平行滑动
//        viewPager.setPageTransformer(true, new AlphaPageTransformer());
        //向下的曲线想滑动
//        viewPager.setPageTransformer(true, new RotateDownPageTransformer());
        //向上曲线型滑动
//        viewPager.setPageTransformer(true, new RotateUpPageTransformer());
        //两遍的图片有缩放（梯形）的效果
//        viewPager.setPageTransformer(true, new RotateYTransformer());
        //两边的图片缩小
//        viewPager.setPageTransformer(true, new ScaleInTransformer());
        //组合
        viewPager.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer(new ScaleInTransformer())));
        viewPager.setCurrentItem(Integer.MAX_VALUE/2 - (Integer.MAX_VALUE/2%imageList.size()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * 页面正在滑动时，回调
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 页面切换后调用
             * position 新的页面位置
             */
            @Override
            public void onPageSelected(int position) {
//                Log.e("qqq","position="+position);
                position = position % imageList.size();
//                Log.e("qqq","position % ===="+position);
                //改变指示点的状态
                //把当前点的enable变为true
                pointGroup.getChildAt(position).setEnabled(true);
                //把上一个点设置为false
                pointGroup.getChildAt(lastPosition).setEnabled(false);
                //显示完后，将此时的点，变成上一个点
                lastPosition = position;
            }

            /**
             * 页面状态发生改变时回调
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        isRunning = true;
        //如果注释这个，那就无法自动滑动
        //会去调用handleMessage方法
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    /**
     * 判断是否自动滚动
     */
    protected boolean isRunning = false;

    /*
      * 自动循环：
      * 1、定时器：Timer
      * 2、开子线程 while  true 循环
      * 3、ColckManager
      * 4、 用handler 发送延时信息，实现循环
      */
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //让viewPage滑动到下一页
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

            if (isRunning) {
                handler.sendEmptyMessageDelayed(0, 2000);
            }
        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}
