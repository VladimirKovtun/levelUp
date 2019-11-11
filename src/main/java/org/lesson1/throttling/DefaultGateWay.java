package org.lesson1.throttling;

public class DefaultGateWay implements Gateway {
    private int requestCounter = 0;

    @Throttling
    @Override
    public void secondProcessRequest(Object request) {
        System.out.println("Request counter: " + ++requestCounter);
    }

    public void method() {
        System.out.println("without Annotation");
    }

    @Throttling
    @Override
    public void processRequest(Object request) {
        System.out.println("Request counter: " + ++requestCounter);
    }
}
