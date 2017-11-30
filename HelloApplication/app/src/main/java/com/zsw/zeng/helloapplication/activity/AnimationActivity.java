package com.zsw.zeng.helloapplication.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zsw.zeng.helloapplication.R;
import com.zsw.zeng.helloapplication.widget.ThreeDAnimation;
import com.zsw.zeng.helloapplication.widget.WrapperView;

public class AnimationActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        //视图动画
        //透明度动画
//        AlphaAnimation aa = new AlphaAnimation(0, 1);
//        aa.setDuration(10000);
//        imageView.startAnimation(aa);

        //旋转动画 其参数分别为旋转的起始角度和旋转中心点的坐标
//        RotateAnimation ra = new RotateAnimation(0,360,100,100);
//        ra.setDuration(10000);
//        imageView.startAnimation(ra);

        //旋转动画(以自身中心点开始旋转一周)
//        RotateAnimation ra = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
//        ra.setDuration(10000);
//        imageView.startAnimation(ra);

        //位移动画，为视图移动时增加动画效果
//        TranslateAnimation ta = new TranslateAnimation(0,200,0,300);
//        ta.setDuration(10000);
//        imageView.startAnimation(ta);

        //缩放动画，为视图的缩放增加动画效果
//        ScaleAnimation sa = new ScaleAnimation(0,2,0,2);
//        sa.setDuration(10000);
//        imageView.setAnimation(sa);

        //缩放动画也可以设置缩放的中心点
//        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
//        sa.setDuration(10000);
//        imageView.setAnimation(sa);

        //动画集合
//        AnimationSet as = new AnimationSet(true);
//        as.setDuration(10000);
//
//        AlphaAnimation aa = new AlphaAnimation(0,1);
//        aa.setDuration(10000);
//        as.addAnimation(aa);
//
//        TranslateAnimation ta = new TranslateAnimation(0,100,0,200);
//        ta.setDuration(10000);
//        as.addAnimation(ta);
//
//        imageView.startAnimation(as);

        //监听回调
//        as.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                //动画开始
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                //动画结束
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                //动画重复
//            }
//        });

        //属性动画框架
        //ObjectAnimator
//        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"translationY",300);
//        animator.setDuration(10000);
//        animator.start();
        //WrapperView 缩放之后再平移i
//        WrapperView view = new WrapperView(imageView);
//        ObjectAnimator.ofInt(view, "width", 500).setDuration(5000).start();

        //PropertyValuesHolder 平移动画，同时改变X,Y轴的缩放
//        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX", 300f);
//        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("scaleX",1f,0,1f);
//        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("scaleY",1f,0,1f);
//        ObjectAnimator.ofPropertyValuesHolder(imageView,p1,p2,p3).setDuration(5000).start();

        //ValueAnimator本身不提供任何动画效果，而是让调用者来控制动画的实现过程，ValueAnimator的onAnimationUpdate中监听数值的变化，从而完成动画的变换
//        ValueAnimator animator = ValueAnimator.ofFloat(0, 100);
//        animator.setTarget(imageView);
//        animator.setDuration(10000).start();
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Float value = (Float) animation.getAnimatedValue();
//                //TODO use the value
//                Log.e("qqq", value + "");
//            }
//        });

        //动画事件的监听 一个完整的动画具有Start,End,Cancel,Repeat四个过程，通过Android提供了接口，可以很方便的监听到这四个事件
//        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"alpha",0.5f);
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//
//        animator.addListener(new AnimatorListenerAdapter() {
//            //可以选择必要的事件进行监听
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//            }
//        });
//        animator.start();

        //AnimatorSet通过playTogether,playSequentially,AnimatorSet.play().with(),before(),after()这些方法来控制多个动画的协同工作方式，从而做到对动画播放顺序的精确控制
//        ObjectAnimator oa1 = ObjectAnimator.ofFloat(imageView,"translationX",300f);
//        ObjectAnimator oa2=ObjectAnimator.ofFloat(imageView,"scaleX",1f,0f,1f);
//        ObjectAnimator oa3=ObjectAnimator.ofFloat(imageView,"scaleY",1f,0f,1f);
//        AnimatorSet set = new AnimatorSet();
//        set.setDuration(10000);
//        set.playTogether(oa1,oa2,oa3);
//        set.start();

        //在XML中使用属性动画
//        scaleX(imageView);

        //view的animate方法
//        imageView.animate()
//                .alpha(0)
//                .y(300)
//                .setDuration(10000)
//                .withStartAction(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                }).withEndAction(new Runnable() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
//            }
//        }).start();
        //Android 布局动画
//        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
//        //设置过渡动画
//        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
//        sa.setDuration(10000);
//        //设置布局动画的显示属性
//        LayoutAnimationController lac = new LayoutAnimationController(sa,0.5F);
//        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        //为ViewGroup设置布局动画
//        ll.setLayoutAnimation(lac);

        //自定义动画
//        Animation ani = new Animation() {
//
//            float mCenterWidth;
//            float mCenterHeight;
//
//            @Override
//            public void initialize(int width, int height, int parentWidth, int parentHeight) {
//                super.initialize(width, height, parentWidth, parentHeight);
//                setDuration(1000);
//                setFillAfter(true);
//                //保存View的中心点
//                mCenterWidth = width / 2;
//                mCenterWidth = height / 2;
//                setInterpolator(new AccelerateDecelerateInterpolator());
//            }
//
//            @Override
//            protected void applyTransformation(float interpolatedTime, Transformation t) {
//                super.applyTransformation(interpolatedTime, t);
//                final Matrix matrix = t.getMatrix();
//                matrix.preScale(1, 1 - interpolatedTime, mCenterWidth, mCenterHeight);
////                final Matrix matrix = t.getMatrix();
////                if (interpolatedTime < 0.8) {
////                    matrix.preScale(1+0.625f*interpolatedTime, 1-interpolatedTime/0.8f+0.01f,mCenterWidth,mCenterHeight);
////                }else{
////                    matrix.preScale(7.5f*(1-interpolatedTime),0.005f,mCenterWidth,mCenterHeight);
////                }
//            }
//        };
//        imageView.setAnimation(ani);

        final ThreeDAnimation ani = new ThreeDAnimation();
        //设置旋转角度
        ani.setRotateY(75);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动动画
                button.startAnimation(ani);
            }
        });
    }

    private void scaleX(View imageView) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scalex);
        animator.setTarget(imageView);
        animator.start();
    }


}
