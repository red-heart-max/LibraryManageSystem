package com.chun.text.thread05;

public class Thread05 extends Thread{

    static int ticket=0;
    static Object object=new Object();
    @Override
    public void run() {
        while (true){
            if (method())
                break;
        }
    }

    private static synchronized boolean method() {
        if (ticket<100){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket++;
            System.out.println(Thread.currentThread().getName()+" "+ticket);
        }else {
            return true;
        }
        return false;
    }
}
