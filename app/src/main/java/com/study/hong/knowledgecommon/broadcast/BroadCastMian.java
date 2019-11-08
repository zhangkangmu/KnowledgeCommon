package com.study.hong.knowledgecommon.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.study.hong.knowledgecommon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by hong on 2019/11/6.
 */

public class BroadCastMian extends Activity {
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_sd_card)
    TextView tvSdCard;
    @BindView(R.id.tv_electricity)
    TextView tvElectricity;
    @BindView(R.id.tv_uninstall)
    TextView tvUninstall;
    @BindView(R.id.tv_begain_broadcast)
    TextView tvBegainBroadcast;
    @BindView(R.id.tv_send_disorder_broadcast)
    TextView tvSendDisorderBroadcast;
    @BindView(R.id.receiver_broadcast)
    TextView receiverBroadcast;
    @BindView(R.id.send_oder_demo)
    TextView sendDemo;
    @BindView(R.id.recceiver_demo)
    TextView recceiverDemo;
    @BindView(R.id.special_broadcast_recceiver)
    TextView specialBroadcastRecceiver;
    private Unbinder unbinder;
    private ScreenReceiver screenReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_mian);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_phone, R.id.tv_sd_card, R.id.tv_electricity, R.id.tv_uninstall, R.id.tv_begain_broadcast, R.id.tv_send_disorder_broadcast, R.id.receiver_broadcast, R.id.send_oder_demo, R.id.recceiver_demo, R.id.special_broadcast_recceiver})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_phone:
                break;
            case R.id.tv_sd_card:
                break;
            case R.id.tv_electricity:
                break;
            case R.id.tv_uninstall:
                break;
            case R.id.tv_begain_broadcast:
                break;
            case R.id.tv_send_disorder_broadcast:
                //发无序广播，比如 电台
                Intent intent = new Intent();
                intent.putExtra("name", "新闻联播每天晚上7点准时开整!!!");
                intent.setAction("com.study.hong.knowledgecommon.disorder.broadcast");
                sendBroadcast(intent);

                break;
            case R.id.receiver_broadcast:
                break;
            case R.id.send_oder_demo:
                /**
                 * receiverPermission 接收的权限
                 * resultReceiver 最为一个最终的receive  最后都能够接收到广播
                 */
                Intent intent1 = new Intent();
                intent1.setAction("com.study.hong.knowledgecommon.order.broadcast.rice");
                //void sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
                sendOrderedBroadcast(intent1, null, new FinalReceiver(), null, 1, "习大大给每个村民发了1000斤大米", null);

                break;
            case R.id.recceiver_demo:
                break;
            case R.id.special_broadcast_recceiver:
                //特殊的广播，需要动态注册
// <receiver android:name=".broadcast.ScreenReceiver">
//            <intent-filter>
//                <action android:name="android.intent.action.SCREEN_OFF"/>
//                <action android:name="android.intent.action.SCREEN_ON"/>
//            </intent-filter>
//        </receiver>
//                registerReceiver(BroadcastReceiver, IntentFilter);

                //[1]动态的去注册屏幕解锁和锁屏的广播
                screenReceiver = new ScreenReceiver();
                //[2]创建intent-filter对象
                IntentFilter intentFilter = new IntentFilter();
                //[3]添加要注册的action
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                registerReceiver(screenReceiver, intentFilter);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        unregisterReceiver(screenReceiver);
    }
}
