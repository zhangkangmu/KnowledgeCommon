package com.study.hong.knowledgecommon.broadcast;

import android.app.Activity;
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
    @BindView(R.id.send_demo)
    TextView sendDemo;
    @BindView(R.id.recceiver_demo)
    TextView recceiverDemo;
    @BindView(R.id.special_broadcast_recceiver)
    TextView specialBroadcastRecceiver;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_mian);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_phone, R.id.tv_sd_card, R.id.tv_electricity, R.id.tv_uninstall, R.id.tv_begain_broadcast, R.id.tv_send_disorder_broadcast, R.id.receiver_broadcast, R.id.send_demo, R.id.recceiver_demo, R.id.special_broadcast_recceiver})
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
                break;
            case R.id.receiver_broadcast:
                break;
            case R.id.send_demo:
                break;
            case R.id.recceiver_demo:
                break;
            case R.id.special_broadcast_recceiver:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
