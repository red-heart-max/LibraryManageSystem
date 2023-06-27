package com.chun.text.thread06;

public class Main {
    public static void main(String[] args) {
        Thread06 t1=new Thread06();
        Thread06 t2=new Thread06();
        Thread06 t3=new Thread06();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }


}
