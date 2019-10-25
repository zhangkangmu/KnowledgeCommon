package com.study.hong.knowledgecommon.Animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.study.hong.knowledgecommon.R;

/**
 * https://github.com/tuacy/TransitionDemo     学习看这个github demo
 * 博客这个：https://blog.csdn.net/wuyuxing24/article/details/78857912
 * Created by hong on 2019/10/24.
 * 逐帧动画
 * 主要看frame_animation，在drawble里
 */

public class FrameAnimation extends Activity {

    private AnimationDrawable anim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameanimation);
        AppCompatImageView img = findViewById(R.id.img);
//        AnimationDrawable anim=new AnimationDrawable();
        //        anim = (AnimationDrawable) img.getBackground();
        anim = (AnimationDrawable) img.getDrawable();

        anim.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        anim.stop();
    }
}
