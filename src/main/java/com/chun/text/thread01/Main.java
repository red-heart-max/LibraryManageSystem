package com.chun.text.thread01;

public class Main {
    /**
     * 多线程的启动方式
     * 方式一：
         * 继承thread类
         * 重写run方法
         * 创建子类对象，并启动线程
     *
     */
    public static void main(String[] args) {
        Thread01 t1=new Thread01();
        Thread01 t2=new Thread01();
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }


}
