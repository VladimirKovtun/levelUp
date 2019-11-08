package org.lesson1.throttling;

public class App {

    public static void main(String[] args) {
        ThrottlingAnnotationProcessor processor = new ThrottlingAnnotationProcessor();
        Gateway process = (Gateway) processor.process(new DefaultGateWay());
        process.processRequest(new Object());
    }
}
