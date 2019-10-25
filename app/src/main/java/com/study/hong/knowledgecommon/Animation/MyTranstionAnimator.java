package com.study.hong.knowledgecommon.Animation;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.study.hong.knowledgecommon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hong on 2019/10/25.
 * 过渡动画  https://blog.csdn.net/wuyuxing24/article/details/78857912
 * 通过布局的方式实现
 */
//ChangeBounds：检测View的位置边界创建移动和缩放动画(关注布局边界的变化)
//ChangeTransform:检测View的scale和rotation创建缩放和旋转动画(关注scale和ratation的变化)
//ChangeClipBounds:检测View的剪切区域的位置边界，和ChangeBounds类似。不过ChangeBounds针对的是view而ChangeClipBounds针对的是view的剪切区域setClipBound(Rect rect) 中的rect(关注的是setClipBounds(Rect rect)rect的变化)
//ChangeImageTransform:检测ImageView的ScaleType，并创建相应动画(关注的是ImageView的scaleType)
//Fade:根据View的visibility状态的的不同创建淡入淡动画,调整的是透明度(关注的是View的visibility的状态)
//Slide	根据View的visibility状态的的不同创建滑动动画(关注的是View的visibility的状态)
//Explode	根据View的visibility状态的的不同创建分解动画(关注的是View的visibility的状态)
//AutoTransition	默认动画，ChangeBounds、Fade动画的集合
    /*设置时间则是new这些类的时候setduration*/
public class MyTranstionAnimator extends Activity {

    @BindView(R.id.changebounds)
    Button changebounds;
    @BindView(R.id.changetransform)
    Button changetransform;
    @BindView(R.id.changeclipbounds)
    Button changeclipbounds;
    @BindView(R.id.changeimagetransform)
    Button changeimagetransform;
    @BindView(R.id.fade)
    Button fade;
    @BindView(R.id.explode)
    Button explode;
    @BindView(R.id.autotransition)
    Button autotransition;
    @BindView(R.id.clean)
    Button clean;
    @BindView(R.id.doubleAnimation)
    Button doubleAnimation;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    boolean isFirstScenel;
    private ViewGroup contain;
    private View start;
    private View end;
    private View orign;
    private ChangeBounds changeBounds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transtion_animator);
        ButterKnife.bind(this);

        contain = findViewById(R.id.contain);
        //这两个布局就图片位置不一样
        scene1 = Scene.getSceneForLayout(contain, R.layout.transtion_animator1, this);
        scene2 = Scene.getSceneForLayout(contain, R.layout.transtion_animator2, this);
        scene3 = Scene.getSceneForLayout(contain, R.layout.transtion_animator1_1, this);
        TransitionManager.go(scene1);

        //只有一张图片,做裁剪动画用
        orign = LayoutInflater.from(this).inflate(R.layout.transtion_animator_clip, contain, false);
        start = LayoutInflater.from(this).inflate(R.layout.transtion_animator_clip, contain, false);
        start.findViewById(R.id.img).setClipBounds(new Rect(0, 0, 100, 100));
        end = LayoutInflater.from(this).inflate(R.layout.transtion_animator_clip, contain, false);
        end.findViewById(R.id.img).setClipBounds(new Rect(300, 300, 600, 600));
    }

    @OnClick({R.id.changebounds, R.id.changetransform, R.id.changeclipbounds, R.id.changeimagetransform, R.id.fade, R.id.explode, R.id.autotransition, R.id.clean,R.id.doubleAnimation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //移动和缩放动画
            case R.id.changebounds:
                changeBounds = new ChangeBounds();
//                设置时间
                changeBounds.setDuration(2000);
                TransitionManager.go(isFirstScenel ? scene1 : scene2, changeBounds);
                isFirstScenel = !isFirstScenel;
                break;
            //缩放和旋转动画
            case R.id.changetransform:
                TransitionManager.go(isFirstScenel ? scene1 : scene3, new ChangeTransform());
                isFirstScenel = !isFirstScenel;
                break;
            //移动和缩放动画,针对view的剪切区域setClipBound(Rect rect)
            case R.id.changeclipbounds:
                Scene sceneStart = new Scene(contain, orign);
                Scene sceneEnd = new Scene(contain, orign);
                TransitionManager.go(isFirstScenel ? sceneStart : sceneEnd, new ChangeClipBounds());
                isFirstScenel = !isFirstScenel;
                break;
            //ImageView的ScaleType,居中啥的
            case R.id.changeimagetransform:
                Scene sceneStart1 = new Scene(contain, start);
                Scene sceneEnd1 = new Scene(contain, end);
                //定义两个android:scaleType="fitXY"不一样的布局，然后让他切换
                TransitionManager.go(isFirstScenel ? sceneStart1 : sceneEnd1, new ChangeImageTransform());
                isFirstScenel = !isFirstScenel;
                break;
            //淡入淡动画,调整的是透明度
            case R.id.fade:
                break;
            //根据View的visibility状态的的不同创建分解动画
            case R.id.explode:
                break;
            //移动和缩放动画+透明（淡入）
            case R.id.autotransition:
                TransitionManager.go(isFirstScenel ? scene1 : scene2);
                isFirstScenel = !isFirstScenel;
                break;
            case R.id.doubleAnimation:
                TransitionManager.go(isFirstScenel ? scene1 : scene2,
                        TransitionInflater.from(this).inflateTransition(R.transition.change_bounds_and_change_transform));
                isFirstScenel = !isFirstScenel;
                break;
            case R.id.clean:
                TransitionManager.go(scene1);
                break;

        }
    }
}
