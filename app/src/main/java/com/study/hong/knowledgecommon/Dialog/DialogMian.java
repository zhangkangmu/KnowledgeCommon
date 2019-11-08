package com.study.hong.knowledgecommon.Dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.os.SystemClock;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.Toast;

import com.study.hong.knowledgecommon.R;

/**
 * Created by hong on 2019/11/8.
 */

public class DialogMian extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_mian);
    }

    // 点击按钮 弹出一个普通对话框
    public void click1(View v) {

        // 构建AlertDialog
        AlertDialog.Builder builder = new Builder(this);
        builder.setTitle("警告");
        builder.setMessage("世界上最遥远的距离是没有网络");
        builder.setPositiveButton("确定", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                System.out.println("点击了确定按钮 执行的逻辑");

            }
        });
        builder.setNegativeButton("取消", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                System.out.println("点击了取消按钮");
            }
        });
        // 最后一步一定要记得 show出来
        builder.show();

    }

    // 点击按钮 弹出一个单选对话框
    public void click2(View v) {

        // 构建AlertDialog
        AlertDialog.Builder builder = new Builder(this);
        builder.setTitle("请选择您喜欢的课");
        final String items[] = { "Android", "ios", "php", "c", "C++", "html" };
        builder.setSingleChoiceItems(items, -1, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // 取出点中的条目
                String item = items[which];
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
                // 关闭当前对话框
                dialog.dismiss();
            }
        });

        // 最后一步一定要记得 show出来
        builder.show();

    }

    // 点击按钮 弹出一个多选对话框
    public void click3(View v) {
        // 构建AlertDialog
        AlertDialog.Builder builder = new Builder(this);
        builder.setTitle("请选择您喜欢吃的水果");
        final String items[] = { "榴莲", "苹果", "葡萄", "香蕉", "黄瓜", "火龙果", "荔枝" };
        final boolean[] checkedItems = { true, false, false, false, false,
                false, true };
        builder.setMultiChoiceItems(items, checkedItems,
                new OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {

                    }
                });
        builder.setPositiveButton("确定", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                StringBuffer sb = new StringBuffer();
                // [1]把你选中的水果给取出来
                for (int i = 0; i < checkedItems.length; i++) {
                    if (checkedItems[i]) {
                        // 就证明是选中的
                        String fruit = items[i];
                        sb.append(fruit + " ");

                    }

                }

                Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT)
                        .show();
                // 关闭对话框
                dialog.dismiss();

            }
        });

        // 最后一步一定要记得 show出来
        builder.show();

    }

    //进度条对话框
    public void click4(View v) {

        //与进度相关的控件都可以直接在子线程更新ui
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("正在玩命加载ing");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();
        //设置进度条的最大值
        dialog.setMax(100);
        new Thread(){public void run() {
            for (int i = 0; i <= 100; i++) {
                //设置当前的进度

                SystemClock.sleep(50);//睡眠50毫秒
                dialog.setProgress(i);
            }
            //关闭对话框
            dialog.dismiss();


        };}.start();


    }
}
