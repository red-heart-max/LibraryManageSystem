package com.chun.text.thread01;

/**
 * 继承thread类
 */
public class Thread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName()+"HelloWorld");
        }
    }
}
