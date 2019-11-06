package com.study.hong.knowledgecommon;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.study.hong.knowledgecommon.Animation.FrameAnimation;
import com.study.hong.knowledgecommon.Animation.MyTranstionAnimator;
import com.study.hong.knowledgecommon.Animation.MyViewPropertyAnimator;
import com.study.hong.knowledgecommon.Animation.PropertAnimation;
import com.study.hong.knowledgecommon.Animation.TweenAnimation;
import com.study.hong.knowledgecommon.base.ListBean;
import com.study.hong.knowledgecommon.broadcast.BroadCastMian;
import com.study.hong.knowledgecommon.storage.StorageMain;
import com.study.hong.knowledgecommon.thread.MyBitmapUtils;
import com.study.hong.knowledgecommon.thread.MyThreadPool;
import com.study.hong.knowledgecommon.thread.ThraedMain;
import com.study.hong.knowledgecommon.utils.LogUtil;


import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends Activity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private Unbinder unbinder;
    private ArrayList<ListBean> listBeans;
    private HashMap<String, Class> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initDates();
        initListen();
        //初始化Logger,第三方的
//        initLog();
    }



    /**
     * 在这里增加demo名称和类
     */
    private void initDates() {
        map = new HashMap<>();
        listBeans = new ArrayList();
        listBeans.add(new ListBean("帧动画", new FrameAnimation()));
        listBeans.add(new ListBean("补间动画", new TweenAnimation()));
        listBeans.add(new ListBean("属性动画--ObjectAnimator", new PropertAnimation()));
        listBeans.add(new ListBean("属性动画--ViewPropertyAnimator", new MyViewPropertyAnimator()));
        listBeans.add(new ListBean("属性动画--过渡动画", new MyTranstionAnimator()));
        listBeans.add(new ListBean("数据存储", new StorageMain()));
        listBeans.add(new ListBean("Handler的使用", new ThraedMain()));
        listBeans.add(new ListBean("AsyncTask的使用--下载图片", new MyBitmapUtils()));
        listBeans.add(new ListBean("线程池的使用--下载图片", new MyThreadPool()));

        //广播
        listBeans.add(new ListBean("广播的知识点", new BroadCastMian()));
    }

    private void initListen() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(new MianAdapter(listBeans, this));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);

    }


    private void initLog() {
        //        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(false)      //（可选）是否显示线程信息。 默认值为true
//                .methodCount(2)               // （可选）要显示的方法行数。 默认2
//                .methodOffset(7)               // （可选）设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
//                .logStrategy(customLog)  //（可选）更改要打印的日志策略。 默认LogCat
//                .tag("MyTAG")                  //（可选）每个日志的全局标记。 默认PRETTY_LOGGER（如上图）
//                .build();

//        当 isLoggable 返回true时输出日志，否则不输出
//        Logger.addLogAdapter(new AndroidLogAdapter() {
//            @Override public boolean isLoggable(int priority, String tag) {
//                return BuildConfig.DEBUG;
//            }
//        });

//        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
//        Logger.e("zzzzzzzzzz-onCreate");
    }
}
