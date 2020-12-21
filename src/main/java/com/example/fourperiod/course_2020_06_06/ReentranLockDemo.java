package com.example.fourperiod.course_2020_06_06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ReentrantLock reentrantLock = new ReentrantLock();
        int i[] = {0};


        for (int j = 0; j < 10000; j++) {
            executorService.submit(() -> {

                try {
                    reentrantLock.lock();
                    i[0]++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println(i[0]);
    }
}
