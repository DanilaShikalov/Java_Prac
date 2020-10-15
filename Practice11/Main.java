package com.company.Practice11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static long totalSum;
    static long totalFinal;
    static AtomicInteger totalFac = new AtomicInteger(0);
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i <  10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            System.out.println(t.getState());
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        System.out.println("total fac: " + totalFac);
        System.out.println("total final: " + totalFinal);
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private synchronized static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            doFinalWork();
            doFacIn();
            doFacWork();
        }
        return a;
    }

    private synchronized static void doFacIn()
    {
        totalSum++;
    }

    private static void doFacWork()
    {
        totalFac.getAndIncrement();
    }

    private static void doFinalWork()
    {
        lock.lock();
        totalFinal++;
        lock.unlock();
    }
}
