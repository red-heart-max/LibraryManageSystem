package com.chun.text.thread02;

/**
 * 方式二：
 *          * 定义一个类去实现runnable接口
 *          * 重写run方法
 *          * 创建自己的类对象
 *          * 创建一个thread类对象，开启线程
 */
public class Main {
    public static void main(String[] args) {
//        创建任务
        Thread02 t1=new Thread02();
//        创建线程对象
        Thread thread1=new Thread(t1);
        Thread thread2=new Thread(t1);
        //给线程设置名字
        thread1.setName("t1");
        thread2.setName("t2");
//        开启线程
        thread1.start();
        thread2.start();
    }
}
