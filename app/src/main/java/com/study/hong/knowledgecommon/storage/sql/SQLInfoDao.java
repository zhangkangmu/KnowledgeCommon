package com.study.hong.knowledgecommon.storage.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hong on 2019/10/27.
 */

public class SQLInfoDao {

    private final MyDatabaseHelper helper;
    private Cursor cursor;

    public SQLInfoDao(Context context) {
        helper = new MyDatabaseHelper(context);
    }

    public boolean add(CharSequence userName, CharSequence password) {
//        getReadableDatabase并不是以只读方式打开数据库,而是先执行getWritableDatabase,失败的情况下才调用
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();//是用map封装的对象，用来存放值
        values.put("username", (String) userName);
        values.put("password", (String) password);

        //table: 表名 , nullColumnHack：可以为空，标示添加一个空行, values:数据一行的值 , 返回值：代表添加这个新行的Id ，-1代表添加失败
        long result = db.insert("user_message", null, values);//底层是在拼装sql语句

        //关闭数据库对象
        db.close();

        if (result != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int del(CharSequence name) {

        //执行sql语句需要sqliteDatabase对象
        //调用getReadableDatabase方法,来初始化数据库的创建
        SQLiteDatabase db = helper.getReadableDatabase();

        //table ：表名, whereClause: 删除条件, whereArgs：条件的占位符的参数 ; 返回值：成功删除多少行
        int result = db.delete("user_message", "username = ?", new String[]{(String) name});
        //关闭数据库对象
        db.close();

        return result;
    }

    public int update(CharSequence userName, CharSequence password) {

        //执行sql语句需要sqliteDatabase对象
        //调用getReadableDatabase方法,来初始化数据库的创建
        //为什么不能放在构造函数中，因为操作完后要及时关闭
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();//是用map封装的对象，用来存放值
        values.put("username", (String) userName);
        values.put("password", (String) password);
        //table:表名, values：更新的值, whereClause:更新的条件, whereArgs：更新条件的占位符的值,返回值：成功修改多少行
        int result = db.update("user_message", values, "username = ?", new String[]{(String) userName});
        //关闭数据库对象
        db.close();
        return result;
    }

    public String query(CharSequence userName) {

        //执行sql语句需要sqliteDatabase对象
        //调用getReadableDatabase方法,来初始化数据库的创建
        SQLiteDatabase db = helper.getReadableDatabase();

        StringBuilder buffer = new StringBuilder();
        //table:表名, columns：查询的列名,如果null代表查询所有列； selection:查询条件, selectionArgs：条件占位符的参数值,
        //groupBy:按什么字段分组, having:分组的条件, orderBy:按什么字段排序
        if (userName != null) {
            cursor = db.query("user_message", new String[]{"_id", "username", "password"}, "username = ?", new String[]{(String) userName}, null, null, "_id desc");
        } else {
            cursor = db.query("user_message", null, null, null, null, null, "_id desc");
        }
        //解析Cursor中的数据
        if (cursor != null && cursor.getCount() > 0) {//判断cursor中是否存在数据

            //循环遍历结果集，获取每一行的内容
            while (cursor.moveToNext()) {//条件，游标能否定位到下一行
                //获取数据
                int id = cursor.getInt(0);
                String name_str = cursor.getString(1);
                String password_str = cursor.getString(2);
                buffer.append(id + "--" + name_str + "--" + password_str + "\n");
            }
            cursor.close();//关闭结果集

        }
        //关闭数据库对象
        db.close();
        return buffer.toString();
    }
}
