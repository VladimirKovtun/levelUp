package org.lesson3;

public class Consumer implements Runnable {
    private ThreadSafeQueue queue;

    public Consumer(ThreadSafeQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.take().run();
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
