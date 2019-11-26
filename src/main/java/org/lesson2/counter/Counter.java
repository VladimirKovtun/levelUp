package org.lesson2.counter;

public class Counter {
    private long c;

    public void increment() {
        synchronized (this) {
            new Thread(new Worker(new Counter())).start();
            c++;
        }
    }

    public long getC() {
        return c;
    }
}
