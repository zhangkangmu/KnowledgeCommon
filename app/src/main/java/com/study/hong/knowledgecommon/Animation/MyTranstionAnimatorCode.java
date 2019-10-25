package com.study.hong.knowledgecommon.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.study.hong.knowledgecommon.R;
import butterknife.ButterKnife;

/**
 * Created by hong on 2019/10/25.
 * 过渡动画  https://blog.csdn.net/wuyuxing24/article/details/78857912
 * 通过代码的方式实现
 */
public class MyTranstionAnimatorCode extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transtion_animator);
        ButterKnife.bind(this);
    }
}
