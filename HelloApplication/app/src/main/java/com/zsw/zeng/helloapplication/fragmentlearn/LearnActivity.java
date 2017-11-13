package com.zsw.zeng.helloapplication.fragmentlearn;

import android.app.Fragment;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zsw.zeng.helloapplication.R;

/**
 * Fragment状态的持久化
 * <p>
 * 由于Activity会经常性的发生配置变化，所以依附它的Fragment就有需要将其状态保存起来问题。下面有两个常用的方法去将Fragment的状态持久化。
 * 方法一：
 * 可以通过protected void onSaveInstanceState(Bundle outState)
 * ,protected void onRestoreInstanceState(Bundle savedInstanceState)
 * 状态保存和恢复的方法将状态持久化。
 * <p>
 * 方法二(更方便,让Android自动帮我们保存Fragment状态)：
 * 我们只需要将Fragment在Activity中作为一个变量整个保存，只要保存了Fragment，那么Fragment的状态就得到保存了，所以呢.....
 * FragmentManager.putFragment(Bundle bundle, String key, Fragment fragment) 是在Activity中保存Fragment的方法。
 * FragmentManager.getFragment(Bundle bundle, String key) 是在Activity中获取所保存的Frament的方法。
 * 很显然，key就传入Fragment的id，fragment就是你要保存状态的fragment，但，我们注意到上面的两个方法，第一个参数都是Bundle，
 * 这就意味着FragmentManager是通过Bundle去保存Fragment的。但是，这个方法仅仅能够保存Fragment中的控件状态，比如说EditText中用户已经输入的文字
 * （注意！在这里，控件需要设置一个id，否则Android将不会为我们保存控件的状态），而Fragment中需要持久化的变量依然会丢失，但依然有解决办法，就是利用方法一！
 */
public class LearnActivity extends AppCompatActivity {

    FragmentB fragmentB = new FragmentB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        if (savedInstanceState != null) {
            fragmentB = (FragmentB) getSupportFragmentManager().getFragment(savedInstanceState, "fragmentB");
        }
        init();
    }

    private void init() {
        /**
         *
         FragmentTransaction transaction = getFragmentManager().benginTransatcion();//开启一个事务
         transaction.add();
         //往Activity中添加一个Fragment

         transaction.remove()
         //从Activity中移除一个Fragment，如果被移除的Fragment没有添加到回退栈（回退栈后面会详细说），这个Fragment实例将会被销毁。

         transaction.replace()
         //使用另一个Fragment替换当前的，实际上就是remove()然后add()的合体~

         transaction.hide()
         //隐藏当前的Fragment，仅仅是设为不可见，并不会销毁

         transaction.show()
         //显示之前隐藏的Fragment

         detach()
         //当fragment被加入到回退栈的时候，该方法与*remove()*的作用是相同的，
         //反之，该方法只是将fragment从视图中移除，
         //之后仍然可以通过*attach()*方法重新使用fragment，
         //而调用了*remove()*方法之后，
         //不仅将Fragment从视图中移除，fragment还将不再可用。

         attach()
         //重建view视图，附加到UI上并显示。

         transatcion.commit()
         //提交一个事务
         */
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (fragmentB != null) {
            getSupportFragmentManager().putFragment(outState, "fragmentB", fragmentB);
        }
        super.onSaveInstanceState(outState, outPersistentState);
    }


}
