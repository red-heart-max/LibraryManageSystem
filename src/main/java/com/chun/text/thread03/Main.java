package com.chun.text.thread03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread03 thread03=new Thread03();
        FutureTask<Integer> ft=new FutureTask<>(thread03);
        Thread t1=new Thread(ft);
        t1.start();
        Integer integer = ft.get();
        System.out.println(integer);
    }
}
