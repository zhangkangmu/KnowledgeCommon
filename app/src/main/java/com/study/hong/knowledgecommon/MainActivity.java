package com.study.hong.knowledgecommon;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.study.hong.knowledgecommon.Animation.FrameAnimation;
import com.study.hong.knowledgecommon.base.ListBean;
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
    }
    private void initDates() {
        map = new HashMap<>();
        listBeans = new ArrayList<ListBean>();
        listBeans.add(new ListBean("zzz", new FrameAnimation()));
        listBeans.add(new ListBean("zz23sz", new FrameAnimation()));
        listBeans.add(new ListBean("zzsdasdz", new FrameAnimation()));
        listBeans.add(new ListBean("zzsaddasz", new FrameAnimation()));
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
}
