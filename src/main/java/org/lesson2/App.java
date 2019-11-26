package org.lesson2;

public class App {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread counter = new Thread(new Counter());
        counter.start();
        //MyThread myThread2 = new MyThread();
        myThread.start();
        myThread.join();
        //myThread2.start();
        //myThread2.join();
        System.out.println("Hello from " + Thread.currentThread().getName());
        Thread.sleep(400);
        counter.interrupt();
    }
}
