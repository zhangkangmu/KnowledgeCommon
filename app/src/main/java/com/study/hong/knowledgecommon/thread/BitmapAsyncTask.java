package com.study.hong.knowledgecommon.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by hong on 2019/10/29.
 */
//实际上AsyncTask是handler+线程池
//第一个泛型：对应doInBackground的参数类型
//第二个泛型：对应onProgressUpdate的参数类型
//第三个泛型：对应doInBackground的返回结果和onPostExecute的参数类型
public class BitmapAsyncTask extends AsyncTask<Object, Integer, Bitmap> {
    private final LocalCacheUtils localCacheUtils;

    public BitmapAsyncTask(LocalCacheUtils localCacheUtils) {
        this.localCacheUtils=localCacheUtils;
    }

    private HttpURLConnection con;
    private InputStream stream;
    private ImageView imageView;
    private String url;

    /**
     * 执行第一步 这里为预处理操作，被UI线程所调用（可以在这里完成进度条的属性设置）
     * 主线程运行
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * 执行第二步 这里为异步线程，在这里处理耗时任务操作(比如：下载，读取文件)
     * 通过调用publishProgress方法（传递即时任务进度）可以触发onProgressUpdate的执行
     * 子线程中运行
     * task.execute（参数1，参数2）等参数就是传到这里
     */
    @Override
    protected Bitmap doInBackground(Object[] objects) {
        imageView = (ImageView) objects[0];
        url = (String) objects[1];
//        publishProgress();  //通知进度
//        这里注意要setTag，跟url绑定在一起，防止图片错乱
        imageView.setTag(url);
        Bitmap dowmload = dowmload(url);
        return dowmload;
    }


    /**
     * 执行第三步 这里为实时UI更新操作，被UI线程所调用 在这里可以即时更新（如进度条进度）
     * 主线程运行，更新ui
     */
    @Override
    protected void onProgressUpdate(Integer[] values) {
        super.onProgressUpdate(values);
    }

    /**
     * 执行第四步 在这里会返回doInBackground的操作结果，被UI线程调用，更新最后UI结果
     * 主线程中运行，更新进度
     */
    @Override
    protected void onPostExecute(Bitmap result) {
        if (result!=null){
            if (imageView.getTag().equals(url)){
                imageView.setImageBitmap(result);
                localCacheUtils.setBitmapToLocal(result,url);
            }
        }
    }


    private Bitmap dowmload(String url) {
        try {
            con = (HttpURLConnection) new URL(url).openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestMethod("GET");
            con.connect();
            if (con.getResponseCode() == 200) {
                stream = con.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(stream);
                return bitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream!=null){
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (con!=null){
                con.disconnect();
            }
        }
        return null;
    }
}
