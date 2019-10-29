package com.study.hong.knowledgecommon;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import org.litepal.LitePalApplication;

/**
 * Created by hong on 2019/10/28.
 */

public class MyApplication extends LitePalApplication {
    private static Context context;
    private static Handler handler;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        MyApplication.context = context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static void setHandler(Handler handler) {
        MyApplication.handler = handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static void setMainThreadId(int mainThreadId) {
        MyApplication.mainThreadId = mainThreadId;
    }

    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = Process.myTid();
    }
}
