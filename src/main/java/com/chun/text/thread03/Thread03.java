package com.chun.text.thread03;

import java.util.concurrent.Callable;

/**
 * 多线程实现的第三种方法：
 *      特点：可以获得到多线程运行的结果
 *          1.创建一个类实现Callable接口
 *          2.重写call方法（方法有返回值）
 *          3.创建实现Callable的类对象，表示要执行线程要执行的任务
 *          4.创建FutureTask的对象，管理多线程运行的结果
 *          5.创建thread类对象，并启动线程
 */
public class Thread03 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 1; i <=100 ; i++) {
            sum+=i;
        }
        return sum;
    }
}
