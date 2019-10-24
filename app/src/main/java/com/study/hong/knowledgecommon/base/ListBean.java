package com.study.hong.knowledgecommon.base;

import android.app.Activity;

import com.study.hong.knowledgecommon.Animation.FrameAnimation;

/**
 * Created by hong on 2019/10/24.
 */

public class ListBean {
    private String name;
    private Activity className;

    public ListBean(String name, Activity className) {
        this.className=className;
        this.name=name;
    }

    public Activity getClassName() {
        return className;
    }

    public void setClassName(Activity className) {
        this.className = className;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
