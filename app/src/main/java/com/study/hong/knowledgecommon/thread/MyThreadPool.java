package com.study.hong.knowledgecommon.thread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.study.hong.knowledgecommon.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hong on 2019/10/29.
 */

public class MyThreadPool extends Activity {

    @BindView(R.id.imageview)
    ImageView imageview;
    private HttpURLConnection con;
    private InputStream stream;
    private ImageView imageView;
    private String url;
    private Bitmap dowmload;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            imageview.setImageBitmap(dowmload);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thraed_main);
        ButterKnife.bind(this);

        //开启线程池里的一个线程
        ThreadManager.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                String url = "http://img5.mtime.cn/mg/2019/06/27/104649.48931556_120X90X4.jpg";
                dowmload = dowmload(url);
                mHandler.sendEmptyMessage(0);
            }
        });

    }

    private Bitmap dowmload(String url) {
        try {
            con = (HttpURLConnection) new URL(url).openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestMethod("GET");
            con.connect();
            if (con.getResponseCode() == 200) {
                stream = con.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(stream);
                return bitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (con != null) {
                con.disconnect();
            }
        }
        return null;
    }
}
