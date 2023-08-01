package com.example.demo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Stest {
    private static Semaphore semaphore =new Semaphore(10);
    public static void main(String[] args) {
        for (int i = 0;i<100;i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("====" + Thread.currentThread().getName() + "来到停车场");
                        if (!semaphore.tryAcquire()) {
                            System.out.println("车位不足");
                        }
                        semaphore.acquire();
                        System.out.println("====" + Thread.currentThread().getName() + "进入停车场");
                        Thread.sleep(new Random().nextInt(1000));
                        System.out.println("====" + Thread.currentThread().getName() + "离开停车场");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, i + "号车");
            thread.start();
        }
    }
}
