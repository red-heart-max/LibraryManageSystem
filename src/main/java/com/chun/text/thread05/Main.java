package com.chun.text.thread05;

public class Main {
    public static void main(String[] args) {

        
//        Thread05 t = new Thread05();
//        Thread t1=new Thread(t);
//        Thread t3=new Thread(t);
//        Thread t2=new Thread(t);
//        t1.setName("窗口1");
//        t3.setName("窗口2");
//        t2.setName("窗口3");
//        t1.start();
//        t2.start();
//        t3.start();
        Thread05 t1=new Thread05();
        Thread05 t2=new Thread05();
        Thread05 t3=new Thread05();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
