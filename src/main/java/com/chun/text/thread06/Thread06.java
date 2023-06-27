package com.chun.text.thread06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread06 extends Thread{
    static int ticket=0;
    static Lock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if (ticket>=100){
                    break;
                }else {
                    Thread.sleep(100);
                    ticket++;
                    System.out.println(getName()+" "+ticket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
