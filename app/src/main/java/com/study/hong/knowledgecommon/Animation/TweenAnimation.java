package com.study.hong.knowledgecommon.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.study.hong.knowledgecommon.R;

/**
 * Created by hong on 2019/10/24.
 */

public class TweenAnimation extends Activity {

    private ImageView img;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;
    private ImageView img8;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        alphaAnimation();
        translateAnimation();
        scaleAnimation();
        rotateAnimation();


    }

    /**
     * 旋转动画
     */
    private void rotateAnimation() {
        //布局实现
        img7 = findViewById(R.id.img7);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_rotate_animation);
        img7.setAnimation(animation);

        //代码实现
        img8 = findViewById(R.id.img8);
        //参数：起始度数，结束度数，相对位置，x中心位置，相对位置，y中心位置
        RotateAnimation  rotateAnimation=new RotateAnimation(0,480,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(5000);
        rotateAnimation.setFillAfter(true);
        img8.setAnimation(rotateAnimation);
    }

    private void scaleAnimation() {
       //布局实现
        img5 = findViewById(R.id.img5);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_scale_animation);
        img5.setAnimation(animation);

        //代码实现
        img6 = findViewById(R.id.img6);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 2f, 0.3f, 3f,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
        scaleAnimation.setDuration(5000);
        scaleAnimation.setFillAfter(true);
        img6.setAnimation(scaleAnimation);
    }

    /**
     * view的透明动画
     */
    private void alphaAnimation() {
        img = findViewById(R.id.img);
        //布局的实现方式
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_alpha_animation);
        img.setAnimation(animation);

        //直接用代码实现
        img2 = findViewById(R.id.img2);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(5000);
        alphaAnimation.setFillAfter(true);  //结束的时候停留这个
        img2.setAnimation(alphaAnimation);
    }

    /**
     * view的平移动画
     */
    private void translateAnimation() {
        //布局实现
        img3 = findViewById(R.id.img3);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_translate_animation);
        initInterpolator(animation);//插值器
        img3.setAnimation(animation);

        //代码实现
        img4 = findViewById(R.id.img4);
        //TranslateAnimation的方式1：没有相对于谁，偏移多少固定
//        TranslateAnimation translateAnimation = new TranslateAnimation(0,100,0,100);
        //参数：x位置模式，x初始坐标，x位置模式，x移动后坐标，y位置模式，y初始坐标，y位置模式，y移动后坐标
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,2f,
                Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,2f);
        translateAnimation.setDuration(2000);
        translateAnimation.setFillAfter(true);
        img4.setAnimation(translateAnimation);

    }

    /**
     * 插值器
     * @param animation
     */
    private void initInterpolator(Animation animation) {
        AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();  //先加速再减速
        AccelerateInterpolator interpolator1 = new AccelerateInterpolator(); //动画加速进行
        OvershootInterpolator interpolator2 = new OvershootInterpolator(); //快速完成动画，超出再回到结束样式
        AnticipateInterpolator interpolator3 = new AnticipateInterpolator(); //先退后再加速前进
        AnticipateOvershootInterpolator interpolator4 = new AnticipateOvershootInterpolator(); //先退后再加速前进，超出终点后再回终点
        BounceInterpolator interpolator5 = new BounceInterpolator(); //最后阶段弹球效果
        AnticipateOvershootInterpolator interpolator6 = new AnticipateOvershootInterpolator(); //先退后再加速前进，超出终点后再回终点
        //参数
        CycleInterpolator interpolator7 = new CycleInterpolator(2); //周期运动
        DecelerateInterpolator interpolator8 = new DecelerateInterpolator(); //减速
        LinearInterpolator interpolator9 = new LinearInterpolator(); //匀速

        animation.setInterpolator(interpolator5);
    }
}
