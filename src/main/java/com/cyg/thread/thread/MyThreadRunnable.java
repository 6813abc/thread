package com.cyg.thread.thread;

/**
 * 如果自己的类已经 extends 另一个类,就无法直接 extends Thread,
 * 此时,可以实现一个Runnable 接口.
 *
 * @author cyg
 * @date 2019/3/5 下午7:12
 **/
public class MyThreadRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println("MyRead.run()方法");
    }

    public static void main(String[] args) {
        //启动 MyThread,需要首先实例化一个 Thread,并传入自己的 MyThread 实例
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        Thread thread = new Thread(myThreadRunnable);
        thread.run();
    }

    //事实上,当传入一个 Runnable target 参数给 Thread 后,Thread 的 run()方法就会调用target.run()
    /*public void run() {
        if (target != null) {
            target.run();
        }
    }*/
}
