package com.study.hong.knowledgecommon.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.study.hong.knowledgecommon.MainActivity;
import com.study.hong.knowledgecommon.utils.LogUtil;

/**
 * Created by hong on 2019/11/8.
 */

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction()))
        LogUtil.e("zzzzzzz重启了");
        Intent intent1 = new Intent(context, MainActivity.class);
        //activity要在一个任务栈中运行，重启后没有任务栈，所以要增加一个flag
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
