package com.study.hong.knowledgecommon.Animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.study.hong.knowledgecommon.R;

/**
 * Created by hong on 2019/10/25..
 * 精简代码以及快速实现,
 */

public class MyViewPropertyAnimator extends Activity {
    private Button button;
    private Button button2;
    private TextView textview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propert_animation);
        button = findViewById(R.id.button);
        textview = findViewById(R.id.textview);
        //不加By代表直接移动某个值, 加了By代表在原有基础上移动某个值.
        textview.animate().translationYBy(500).scaleXBy(2).scaleYBy(2).rotation(360).setDuration(5000);
/*
        //其他用法
        textview.animate()// 获取ViewPropertyAnimator对象
                // 动画持续时间
                .setDuration(5000)

                // 透明度
                .alpha(0)
                .alphaBy(0)

                // 旋转
                .rotation(360)
                .rotationBy(360)
                .rotationX(360)
                .rotationXBy(360)
                .rotationY(360)
                .rotationYBy(360)

                // 缩放
                .scaleX(1)
                .scaleXBy(1)
                .scaleY(1)
                .scaleYBy(1)

                // 平移
                .translationX(100)
                .translationXBy(100)
                .translationY(100)
                .translationYBy(100)
                .translationZ(100)
                .translationZBy(100)

                // 更改在屏幕上的坐标
                .x(10)
                .xBy(10)
                .y(10)
                .yBy(10)
                .z(10)
                .zBy(10)

                // 插值器
                .setInterpolator(new BounceInterpolator())//回弹
                .setInterpolator(new AccelerateDecelerateInterpolator())//加速再减速
                .setInterpolator(new AccelerateInterpolator())//加速
                .setInterpolator(new DecelerateInterpolator())//减速
                .setInterpolator(new LinearInterpolator())//线性

                // 动画延迟
                .setStartDelay(1000)

                //是否开启硬件加速
                .withLayer()

                // 监听
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                })

                .setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                    }
                })

                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                    }
                })
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
*/

    }
}
