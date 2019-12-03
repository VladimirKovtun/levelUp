package org.lesson7;

public class BlockInitiakizations {

    static {
        System.out.println("Call static1");
    }

    {
        System.out.println("Call1");
    }

    public BlockInitiakizations() {
        System.out.println("Call constuctor");
    }

    {
        System.out.println("Call2");
    }

    static {
        System.out.println("Call static2");
    }
}
