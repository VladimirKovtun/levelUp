package org.lesson2.counter;

public class Worker implements Runnable {
    private Counter counter;

    public Worker(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        counter.increment();
        /*while (!Thread.currentThread().isInterrupted()) {
        }*/
    }
}
