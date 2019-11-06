package com.study.hong.knowledgecommon.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.study.hong.knowledgecommon.utils.LogUtil;

import java.util.logging.Logger;

/**
 * Created by hong on 2019/11/6.
 */

public class SdcardReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
            LogUtil.e("zzzzzzzzz--收到sd卡卸载的广播");

        } else if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
            LogUtil.e("zzzzzzzzz---收到sd卡挂载的广播");
        }
    }
}
