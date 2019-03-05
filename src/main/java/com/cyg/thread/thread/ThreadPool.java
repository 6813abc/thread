package com.cyg.thread.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程和数据库连接这些资源都是非常宝贵的资源。那么每次需要的时候创建,不需要的时候销
 * 毁,是非常浪费资源的。那么我们就可以使用缓存的策略,也就是使用线程池。
 *
 * @author cyg
 * @date 2019/3/5 下午9:37
 **/
public class ThreadPool implements Runnable {

    @Override
    public void run() {
        System.out.println("ThreadPool.run()方法");
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ThreadPool myThreadRunnable = new ThreadPool();
        threadPool.execute(myThreadRunnable);
    }
}
