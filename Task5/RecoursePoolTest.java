package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RecoursePoolTest {
    @Test
    public void testConstructPool() {
        ResourcePool<Thread> pool = new ResourcePool<Thread>(new ThreadFactory(), 10, 500);
        Assertions.assertEquals(10, pool.size);
    }

    @Test
    public void testDropResource() {
        ResourcePool<Thread> pool = Mockito.mock(ResourcePool.class);
        Thread thread = new Thread();
        pool.dropResource(thread);
        Mockito.verify(pool, Mockito.times(1)).dropResource(thread);
    }

    @Test
    public void testShutdown() {
        ResourcePool<Thread> pool = Mockito.mock(ResourcePool.class);
        pool.shutdown();
        Mockito.verify(pool, Mockito.times(1)).shutdown();
    }

    @Test
    public void testNewResource() {
        ResourcePool<Thread> pool = Mockito.mock(ResourcePool.class);
        pool.newResource();
        Mockito.verify(pool, Mockito.times(1)).newResource();
    }

    @Test
    public void testGetResource() {
        ResourcePool<Thread> pool = Mockito.mock(ResourcePool.class);
        pool.getResource();
        pool.getResource();
        Mockito.verify(pool, Mockito.times(2)).getResource();
    }

    @Test
    public void testNewResourceShutdown() {
        ResourcePool<Thread> pool = new ResourcePool<Thread>(new ThreadFactory(), 10, 500);
        pool.shutdown();
        Assertions.assertThrows(IllegalStateException.class, () -> pool.newResource());
    }

    @Test
    public void testGetResourceShutdown() {
        ResourcePool<Thread> pool = new ResourcePool<Thread>(new ThreadFactory(), 10, 500);
        pool.shutdown();
        Assertions.assertNull(pool.getResource());
    }

    @Test
    public void testDropResourceShutdown() {
        ResourcePool<Thread> pool = new ResourcePool<Thread>(new ThreadFactory(), 10, 500);
        pool.shutdown();
        Thread thread = new Thread();
        Assertions.assertThrows(IllegalStateException.class, () -> pool.dropResource(thread));
    }

    @Test
    public void testDropNull() {
        ResourcePool<Thread> pool = new ResourcePool<Thread>(new ThreadFactory(), 10, 500);
        Assertions.assertThrows(IllegalArgumentException.class, () -> pool.dropResource(null));
    }


}