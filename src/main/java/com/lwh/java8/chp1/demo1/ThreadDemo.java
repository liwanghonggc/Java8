package com.lwh.java8.chp1.demo1;

/**
 * @author lwh
 * @date 2018-11-13
 * @desp 使用Lambda创建线程demo
 */
public class ThreadDemo {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
