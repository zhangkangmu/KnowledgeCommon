package com.study.hong.knowledgecommon.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by hong on 2019/10/29.
 */

public class LocalCacheUtils {

    // 图片缓存的文件夹
    public static final String DIR_PATH = Environment
            .getExternalStorageDirectory().getAbsolutePath()
            + "/bitmap_cache66";

    public Bitmap getBitmapFromLocal(String url) {
        try {
            File file = new File(DIR_PATH, MD5Encoder.encode(url));

            if (file.exists()) {
                Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(
                        file));
                return bitmap;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setBitmapToLocal(Bitmap bitmap, String url) {
        File dirFile = new File(DIR_PATH);

        // 创建文件夹
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            dirFile.mkdirs();
        }

        try {
            File file = new File(DIR_PATH, MD5Encoder.encode(url));
            // 将图片压缩保存在本地,参1:压缩格式;参2:压缩质量(0-100);参3:输出流
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,
                    new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
