package com.cyg.thread.thread;

/**
 * Thread类本质上是实现了Runnable接口的一个方法,代表一个线程的实例.
 * 启动线程的唯一方法是通过Thread类的start()实例方法.
 * start()方法是一个native方法,它将启动一个信息线程,并执行run()方法.
 *
 * @author cyg
 * @date 2019/3/5 下午7:04
 **/
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }
}
