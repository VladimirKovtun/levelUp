package org.lesson1.throttling;

public interface Gateway {

    void processRequest(Object request);
    void secondProcessRequest(Object request);
}
