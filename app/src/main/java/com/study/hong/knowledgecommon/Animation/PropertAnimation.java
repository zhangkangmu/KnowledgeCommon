package com.study.hong.knowledgecommon.Animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.study.hong.knowledgecommon.R;

/**
 * Created by hong on 2019/10/24.
 */

public class PropertAnimation extends Activity {

    private Button button;
    private Button button2;
    private TextView textview;
    float curTranslationY;
    private float curTranslationY1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propert_animation);
        button = findViewById(R.id.button);
        textview = findViewById(R.id.textview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //单个
                //参数还有："alpha", "rotation",等等
//                ObjectAnimator animator
//                        = ObjectAnimator.ofFloat(textview,"translationY",curTranslationY, curTranslationY+100);
//                animator.setDuration(2000);
//                animator.start();
//                curTranslationY=curTranslationY+100;

              /*详解
              after(Animator anim) after中的动画先执行, 之后才是play中的动画.
              after(long delay) after中设置时间, 那么play中的动画会根据时间延迟执行.
              before(Animator anim) before中的动画后执行, play中的先执行.
              with(Animator anim) play中的动画和with中的一同执行.
              playTogether() 中间可以放入要一起执行的全部动画, 之后不可接after(), before()这些函数
               */
                //多个动画合集
                // 垂直移动
                curTranslationY1 = textview.getTranslationY();
                //平移
                ObjectAnimator translationY
                        = ObjectAnimator.ofFloat(textview, "translationY",
                        curTranslationY1, curTranslationY1 + 500f);
                //缩放
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(textview, "scaleY", 1f, 3f, 1f);
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(textview, "scaleX", 1f, 3f, 1f);
                //透明
                ObjectAnimator alpha = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);

                AnimatorSet animSet = new AnimatorSet();
//                animSet.play(scaleY).with(scaleX).with(alpha).after(translationY);
                animSet.playTogether(translationY, scaleX, scaleY, alpha);
                animSet.setDuration(2000);
                animSet.start();
            }
        });
        button2 = findViewById(R.id.button2);
        final AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.proper_animation);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                animator.setDuration(2000);
                animator.setTarget(textview);
                animator.start();
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast.makeText(getApplicationContext(),"开始动画",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(getApplicationContext(),"动画结束",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
