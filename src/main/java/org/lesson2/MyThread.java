package org.lesson2;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
