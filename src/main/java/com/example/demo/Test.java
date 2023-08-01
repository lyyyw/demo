package com.example.demo;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 3, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        CountDownLatch startCount = new CountDownLatch(10);
        for (int i=0;i<5;i++){
            threadPoolExecutor.execute(() ->{
                try {
                    Thread.sleep(100*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startCount.countDown();
                }
            });
        }
        startCount.await(1000L,TimeUnit.MILLISECONDS);
        System.out.println("gg");
    }

}
