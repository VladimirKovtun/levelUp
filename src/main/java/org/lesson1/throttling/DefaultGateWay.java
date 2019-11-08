package org.lesson1.throttling;

public class DefaultGateWay implements Gateway {
    private int requestCounter = 0;

    @Throttling
    public void processRequest(Object request) {
        System.out.println("Request counter: " + ++requestCounter);
    }

    public void method() {
        System.out.println("without Annotation");
    }
}
