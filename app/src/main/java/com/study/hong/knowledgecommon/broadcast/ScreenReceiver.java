package com.study.hong.knowledgecommon.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by hong on 2019/11/8.
 * 特殊的广播，需要动态注册，比如说频繁的广播--灭屏
 */

public class ScreenReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
