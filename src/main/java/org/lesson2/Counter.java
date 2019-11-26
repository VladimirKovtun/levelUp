package org.lesson2;

public class Counter implements Runnable {
    private int counter;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            counter++;
        }
        System.out.println("Counter " + counter);
    }
}
