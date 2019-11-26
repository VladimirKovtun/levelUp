package org.lesson3;

public class App {

    public static void main(String[] args) {
        ThreadSafeQueue queue = new ThreadSafeQueue(10);
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();

        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
