package org.lesson3;

public class Producer implements Runnable {
    private ThreadSafeQueue queue;

    public Producer(ThreadSafeQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.add(new Task(i));
                if (i == 5) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
