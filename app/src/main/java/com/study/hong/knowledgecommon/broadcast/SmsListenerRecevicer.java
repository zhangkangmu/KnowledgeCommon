package com.study.hong.knowledgecommon.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

import com.study.hong.knowledgecommon.utils.LogUtil;

/**
 * Created by hong on 2019/11/8.
 */

public class SmsListenerRecevicer extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //[1]获取发短信送的号码  和内容
        Object[] objects = (Object[]) intent.getExtras().get("pdus");
        for (Object pdu :objects) {
            //[2]获取smsmessage实例
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
            //[3]获取发送短信的内容
            String messageBody = smsMessage.getMessageBody();
            //[4]获取发送者
            String originatingAddress = smsMessage.getOriginatingAddress();
            LogUtil.e("zzzzzz-pdu:"+messageBody+"---"+originatingAddress);
        }
    }
}
