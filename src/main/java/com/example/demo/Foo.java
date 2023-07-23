package com.example.demo;

import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore two;
    private Semaphore three;
    public Foo() {
        two = new Semaphore(0);
        three = new Semaphore(0);

    }

    public static void main(String[] args) {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire(1);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire(1);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
