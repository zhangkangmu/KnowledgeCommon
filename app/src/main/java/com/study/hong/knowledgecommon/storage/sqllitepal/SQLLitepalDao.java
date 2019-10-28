package com.study.hong.knowledgecommon.storage.sqllitepal;

import org.litepal.crud.DataSupport;

/**
 * Created by hong on 2019/10/28.
 * 这是数据库里的一个表
 */

public class SQLLitepalDao extends DataSupport {
    private int phone;

    private String nameName;
    private String password;

    public String getName() {
        return nameName;
    }

    public void setName(String name) {
        this.nameName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
