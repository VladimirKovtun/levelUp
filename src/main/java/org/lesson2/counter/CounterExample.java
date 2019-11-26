package org.lesson2.counter;

public class CounterExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new Worker(counter));
        //Thread t2 = new Thread(new Worker(counter));
        //Thread t3 = new Thread(new Worker(counter));

        t1.start();
        //t2.start();
        //t3.start();

        Thread.sleep(400);

        //t1.interrupt();
        //t2.interrupt();
        //t3.interrupt();

        System.out.println("Count: " + counter.getC());
    }
}
