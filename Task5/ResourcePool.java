package com.company;

import java.lang.reflect.Type;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ResourcePool<type> {
    private final LinkedBlockingQueue<Term<type, Long>> pool;
    private LinkedBlockingQueue<Term<type, Long>> poolActivated;
    public final int size;
    private final long aliveTime;
    boolean stopped;
    private final ExecutorService executor;
    ResourceFactory<type> resourceFactory;

    public ResourcePool(ResourceFactory<type> resourceFactory, int size, long aliveTime) {
        this.aliveTime = aliveTime;
        this.size = size;
        this.resourceFactory = resourceFactory;
        stopped = false;
        executor = Executors.newCachedThreadPool();
        pool = new LinkedBlockingQueue<>(size);
        poolActivated = new LinkedBlockingQueue<>();
        for (int i = 0; i < size; i++) {
            this.pool.offer(newResource());
        }
    }

    public ResourcePool(ResourceFactory<type> resourceFactory, long aliveTime) {
        this.aliveTime = aliveTime;
        size = Runtime.getRuntime().availableProcessors();
        this.resourceFactory = resourceFactory;
        stopped = false;
        executor = Executors.newCachedThreadPool();
        pool = new LinkedBlockingQueue<>(size);
        poolActivated = new LinkedBlockingQueue<>();
        for (int i = 0; i < size; i++) {
            this.pool.offer(newResource());
        }
    }

    public Term<type, Long> newResource() {
        if (!stopped) {
            return new Term<type, Long>(resourceFactory.create(), System.currentTimeMillis());
        }
        throw new IllegalStateException("The pool is shutdown");
    }

    public Term<type, Long> getResource() {
        if (!stopped) {
            long now = System.currentTimeMillis();
            long time;
            try {
                Term<type, Long> taken = pool.take();
                if (taken.isAlive(aliveTime)) {
                    poolActivated.offer(taken);
                    return taken;
                } else {
                    Term<type, Long> created = newResource();
                    if (poolActivated.offer(created)) {
                        return created;
                    } else {
                        return null;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public void dropResource(type data) {
        if (data == null) {
            throw new IllegalArgumentException("Resource is null");
        }
        if (stopped) {
            throw new IllegalStateException("The pool is shutdown");
        }
        poolActivated.remove(data);
        Term<type, Long> refResource = new Term(data, System.currentTimeMillis());
        this.pool.offer(refResource);
    }

    public void shutdown() {
        stopped = true;
        executor.shutdownNow();
    }
}
