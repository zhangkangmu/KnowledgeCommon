package com.study.hong.knowledgecommon.thread;

import android.util.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hong on 2019/10/29.
 */

public class ThreadManager {
    private static ThreadPool mThreadPool;
    // 获取单例的线程池对象
    public static ThreadPool getThreadPool() {
        if (mThreadPool==null){
            synchronized (ThreadPool.class){
                if (mThreadPool==null){
                    int cpuNum = Runtime.getRuntime().availableProcessors();// 获取处理器数量
                    Log.e("zzzzzzzzz","处理器的数量："+cpuNum);
                    int threadNum = cpuNum * 2 + 1;// 根据cpu数量,计算出合理的线程并发数
                    mThreadPool = new ThreadPool(cpuNum,threadNum,50);
                }

            }
        }
        return mThreadPool;
    }
    //线程池
    public static class ThreadPool {
        private final int corePoolSize; //核心线程数
        private final int maximumPoolSize;  //最大的线程数
        private final long keepAliveTime;  //线程休息的时间
        private ThreadPoolExecutor mExecutor;

        public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
        }

        // 线程池几个参数的理解:
        // 比如去火车站买票, 有10个售票窗口, 但只有5个窗口对外开放. 那么对外开放的5个窗口称为核心线程数,
        // 而最大线程数是10个窗口.
        // 如果5个窗口都被占用, 那么后来的人就必须在后面排队, 但后来售票厅人越来越多, 已经人满为患, 就类似于线程队列已满.
        // 这时候火车站站长下令, 把剩下的5个窗口也打开, 也就是目前已经有10个窗口同时运行. 后来又来了一批人,
        // 10个窗口也处理不过来了, 而且售票厅人已经满了, 这时候站长就下令封锁入口,不允许其他人再进来, 这就是线程异常处理策略.
        // 而线程存活时间指的是, 允许售票员休息的最长时间, 以此限制售票员偷懒的行为.
        public void execute(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            //TimeUnit是这个单位
            mExecutor = new ThreadPoolExecutor(corePoolSize,
                    maximumPoolSize,
                    keepAliveTime,//TimeUnit是这个单位
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingDeque<Runnable>(),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy()
            );
            mExecutor.execute(runnable);
        }

        // 从线程队列中移除对象
        public void cancel(Runnable runnable) {
            if (mExecutor != null) {
                mExecutor.getQueue().remove(runnable);
            }
        }
    }


}
