package com.chun.text.thread02;

/**
 * 实现runnable接口
 */
public class Thread02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"  HelloWorld");
        }
    }
}
