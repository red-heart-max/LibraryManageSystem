package com.chun.text.thread04;

public class Main {
    public static void main(String[] args) {
        Thread04 t1=new Thread04();
        Thread04 t2=new Thread04();
        t1.setPriority(1);
        t1.setPriority(10);
        t1.start();
        t2.start();
    }
}
