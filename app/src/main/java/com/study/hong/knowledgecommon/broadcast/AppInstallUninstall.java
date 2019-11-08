package com.study.hong.knowledgecommon.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.study.hong.knowledgecommon.utils.LogUtil;

/**
 * Created by hong on 2019/11/8.
 * 软件安装卸载的广播
 */

public class AppInstallUninstall extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_INSTALL".equals(action)){
            LogUtil.e("zzzzzzz-INSTALL安装了"+"data:"+intent.getData());
        }else if ("android.intent.action.PACKAGE_ADDED".equals(action)){
            LogUtil.e("zzzzzzz-ADDED安装了"+"data:"+intent.getData());
        }else if ("android.intent.action.PACKAGE_REMOVED".equals(action)){
            Uri data = intent.getData();
            LogUtil.e("zzzzzzz-卸载了"+"data:"+intent.getData());
        }
    }
}
