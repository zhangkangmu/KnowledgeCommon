package com.study.hong.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hong on 2019/11/8.
 */

public class ReceiveCustomReceiver extends BroadcastReceiver {
    //当我发送自定义广播的时候 这个方法就会接收到
    @Override
    public void onReceive(Context context, Intent intent) {
        //[0]终止广播
//		abortBroadcast();

        //[1]取出我们发送广播携带的数据
        String content = intent.getStringExtra("name");
        //[2]把获取到的数据展示到toast上
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
