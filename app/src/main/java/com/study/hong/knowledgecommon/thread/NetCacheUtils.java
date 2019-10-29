package com.study.hong.knowledgecommon.thread;

import android.widget.ImageView;

/**
 * Created by hong on 2019/10/29.
 */

public class NetCacheUtils {

    private final LocalCacheUtils localCacheUtils;

    public NetCacheUtils() {
        localCacheUtils = new LocalCacheUtils();
    }

    public void getBitmapFromNet(ImageView img, String url) {
        BitmapAsyncTask task = new BitmapAsyncTask(localCacheUtils);
        task.execute(img,url);
    }

}
