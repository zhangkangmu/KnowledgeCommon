package com.study.hong.knowledgecommon.thread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.hong.knowledgecommon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hong on 2019/10/29.
 */

public class MyBitmapUtils extends Activity {

    private final NetCacheUtils cacheUtils;
    @BindView(R.id.textview)
    TextView textview;
    @BindView(R.id.net)
    TextView net;
    @BindView(R.id.imageview)
    ImageView imageview;
    private final LocalCacheUtils localCacheUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thraed_main);
        ButterKnife.bind(this);
        net.setVisibility(View.GONE);
        textview.setVisibility(View.GONE);
        String url="http://img5.mtime.cn/mg/2019/06/27/104649.48931556_120X90X4.jpg";
        display(imageview,url);
    }

    public MyBitmapUtils() {
        cacheUtils = new NetCacheUtils();
        localCacheUtils = new LocalCacheUtils();
    }

    public void display(ImageView img, String url) {
        //设置默认图片
//img.setImageResource();
        Bitmap bitmapFromLocal = localCacheUtils.getBitmapFromLocal(url);
        if (bitmapFromLocal!=null){
            img.setImageBitmap(bitmapFromLocal);
            return;
        }
        cacheUtils.getBitmapFromNet(img, url);
    }
}
