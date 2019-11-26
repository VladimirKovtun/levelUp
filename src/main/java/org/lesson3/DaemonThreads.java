package org.lesson3;

public class DaemonThreads {

    public static void main(String[] args) {
        Thread printer = new Printer();
        Thread counter = new DaemonCounter();
        counter.setDaemon(true);

        counter.start();
        printer.start();

    }

    static class Printer extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Message");
        }
    }

    static class DaemonCounter extends Thread {

        @Override
        public void run() {
            int seconds = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(++seconds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
