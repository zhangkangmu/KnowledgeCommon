package com.study.hong.knowledgecommon.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.study.hong.knowledgecommon.utils.LogUtil;

/**
 * Created by hong on 2019/11/6.
 * 1_IP拨号器
 */

public class OutGoingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.e("zzzzzzz--电话短信是：" + getResultData());
    }
}
