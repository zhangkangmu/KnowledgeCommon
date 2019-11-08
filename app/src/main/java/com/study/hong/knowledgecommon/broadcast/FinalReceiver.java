package com.study.hong.knowledgecommon.broadcast;

/**
 * Created by hong on 2019/11/8.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 最终的receiver 不需要再清单文件里面配置
 * @author jhon
 *
 */
public class FinalReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String content = getResultData();

        Toast.makeText(context, "报告习大大"+content, Toast.LENGTH_SHORT).show();


    }

}