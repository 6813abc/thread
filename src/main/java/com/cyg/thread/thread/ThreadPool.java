package com.cyg.thread.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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

        ThreadPool myThreadRunnable = new ThreadPool();
        //1.newFixedThreadPool: 创建一个可重用固定线程数的线程池,以共享的无界队列方式来运行这些线程。在任意点,在大
        //多数 nThreads 线程会处于处理任务的活动状态。如果在所有线程处于活动状态时提交附加任务,
        //则在有可用线程之前,附加任务将在队列中等待。如果在关闭前的执行期间由于失败而导致任何
        //线程终止,那么一个新线程将代替它执行后续的任务(如果需要)。在某个线程被显式地关闭之
        //前,池中的线程将一直存在。
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(myThreadRunnable);


        //2.newCachedThreadPool: 创建一个可根据需要创建新线程的线程池,但是在以前构造的线程可用时将重用它们。对于执行
        //很多短期异步任务的程序而言,这些线程池通常可提高程序性能。调用 execute 将重用以前构造
        //的线程(如果线程可用)。如果现有线程没有可用的,则创建一个新线程并添加到池中。终止并
        //从缓存中移除那些已有 60 秒钟未被使用的线程。因此,长时间保持空闲的线程池不会使用任何资
        //源。
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.execute(myThreadRunnable);

        //3.newScheduledThreadPool:
        //创建一个线程池,它可安排在给定延迟后运行命令或者定期地执行.
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(newRunnable() {
            @Override
            public void run () {
                System.out.println("延迟三秒");
            }
        },3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(newRunnable() {
            @Override
            public void run () {
                System.out.println("延迟 1 秒后每三秒执行一次");
            }
        },1, 3, TimeUnit.SECONDS);
        //4.newSingleThreadExecutor: Executors.newSingleThreadExecutor()返回一个线程池(这个线程池只有一个线程),这个线程
        //池可以在线程死后(或发生异常时)重新启动一个线程来替代原来的线程继续执行下去!
    }
}
