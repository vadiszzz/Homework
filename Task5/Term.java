package com.company;

public class Term<type, Long> {
    private type data;
    private long time;

    public Term(type data, long time) {
        this.data = data;
        this.time = time;
    }

    public type getData() {
        return this.data;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isAlive(long aliveTime) {
        long currTime = System.currentTimeMillis();
        return ((currTime - this.time) < aliveTime);
    }
}
