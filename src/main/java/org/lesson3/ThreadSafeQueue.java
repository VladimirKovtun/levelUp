package org.lesson3;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeQueue {
    private ReentrantLock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();
    private LinkedList<Runnable> tasks;
    private int maxSize;

    ThreadSafeQueue(int maxSize) {
        this.maxSize = maxSize;
        tasks = new LinkedList<>();
    }

    public void add(Runnable task) throws InterruptedException {
        lock.lock();
        try {
            while (tasks.size() == maxSize) {
                full.await();
            }
            tasks.add(task);
            empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Runnable take() throws InterruptedException {
        lock.lock();
        try {
            while (tasks.isEmpty()) {
                empty.await();
            }
            Runnable task = tasks.poll();
            full.signalAll();
            return task;
        } finally {
            lock.unlock();
        }
    }
}
