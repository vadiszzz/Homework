package com.company;

import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
public class QuadraticSolver implements Runnable {
    double[] a, b, c;
    int first,last;
    ResourcePool<Thread> threadResourcePool;
    ResourcePool<FileWriter> fileWriterResourcePool;

    public QuadraticSolver(double[] a, double[] b, double[] c, ResourcePool<FileWriter> fileWriterResourcePool,int first, int last,ResourcePool<Thread> threadResourcePool) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.first= first;
        this.last = last;
        this.fileWriterResourcePool = fileWriterResourcePool;
        this.threadResourcePool = threadResourcePool;
    }


    public void run() {
        int len = a.length;
        Term<FileWriter, Long> term;
        term = fileWriterResourcePool.getResource();
        try (FileWriter fileWriter = term.getData()) {
            for (int i =first;i<last;i++){
                fileWriter.write(solve(a[i],b[i],c[i]));
            }
            fileWriterResourcePool.dropResource(fileWriter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void start(Runnable runnable) {
        Thread thread = threadResourcePool.getResource().getData();
        runnable.run();
        threadResourcePool.dropResource(thread);
    }

    public String solve(double a, double b, double c){
        if (a==0){
            double x = -c/b;
            return String.format("%f" + '\n', x);
        }
        double D= b*b-4*a*c;
        if (D==0){
            double x = -(double)b/(2*a);
            return String.format("%f" + '\n', x);
        }
        else if(D>0){
            double x = (-b+sqrt(abs(D)))/(2*a);
            double y = (-b-sqrt(abs(D)))/(2*a);
            return String.format("%f, %f" + '\n', x, y);
        }
        return "-"+'\n';
    }
}
