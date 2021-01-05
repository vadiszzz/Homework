package com.company;

public class ThreadFactory implements ResourceFactory<Thread> {
    public Thread create() {
        return new Thread();
    }

}
