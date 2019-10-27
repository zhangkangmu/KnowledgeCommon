package com.study.hong.knowledgecommon.storage.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hong on 2019/10/27.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    //context :上下文   ， name：数据库文件的名称    factory：用来创建cursor对象，默认为null
    //version:数据库的版本号，从1开始，如果发生改变，onUpgrade方法将会调用,4.0之后只能升不能将
    public MyDatabaseHelper(Context context) {
        super(context, "user_info.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //通过SQLiteDatabase执行一个创建表的sql语句
        db.execSQL("create table user_message (_id integer primary key autoincrement,name varchar(20),password varchar(11))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//添加一个phone字段
//		db.execSQL("alter table user_message add phone varchar(11)");
    }
}
