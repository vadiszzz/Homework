package com.company;

import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        long time = 5000000;
        ThreadFactory threadFactory = new ThreadFactory();
        String path = System.getProperty("user.home") + File.separator + "Documents";
        path += File.separator + "Log Folder";
        double[] a = new double[10000], b = new double[10000], c = new double[10000];
        ResourcePool<Thread> threadResourcePool = new ResourcePool<>(threadFactory, time);
        ResourcePool<FileWriter> fileWriterResourcePool = new ResourcePool<>(new FileFactory(path), time);
        for (int i = 0; i < 10000; i++) {
            a[i] = Math.random() * 1000;
            b[i] = Math.random() * 1000;
            c[i] = Math.random() * 1000;
        }
        int iter = threadResourcePool.size;
        for (int i =0;i<iter;i++){
            QuadraticSolver quadraticSolver = new QuadraticSolver(a,b,c,fileWriterResourcePool,i*10000/iter,(i+1)*10000/iter,threadResourcePool);
            quadraticSolver.start(quadraticSolver);
        }
    }
}
