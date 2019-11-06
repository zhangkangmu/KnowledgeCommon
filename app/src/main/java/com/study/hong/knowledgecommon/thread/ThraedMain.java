package com.study.hong.knowledgecommon.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.study.hong.knowledgecommon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hong on 2019/10/28.
 * 发不同的消息不一定要使用message，sendEmptyMessageDelayed也可以
 */

public class ThraedMain extends Activity {
    private static final int BEGANLOOPER = 0;
    private static final int NET = 1;
    @BindView(R.id.textview)
    TextView textview;
    @BindView(R.id.net)
    TextView net;
    private Unbinder unbinder;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            switch (msg.what) {
                case BEGANLOOPER:
                    textview.setText(Integer.valueOf(textview.getText().toString()) - 1 + "");
                    net.setText(UIUtils.getNetSpeed(getApplicationContext()));
                    break;
                case NET:
            }
            removeMessages(BEGANLOOPER);
            sendEmptyMessageDelayed(BEGANLOOPER, 1000);
        }


    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thraed_main);
        unbinder = ButterKnife.bind(this);
        refreshUI();
    }

    private void refreshUI() {


        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessageDelayed(BEGANLOOPER, 1000);
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mHandler.removeCallbacksAndMessages(null);
    }
}
