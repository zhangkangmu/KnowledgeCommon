package com.study.hong.knowledgecommon.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.study.hong.knowledgecommon.R;

/**
 * Created by hong on 2019/10/24.
 * 逐帧动画
 */

public class FrameAnimation extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameanimation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
