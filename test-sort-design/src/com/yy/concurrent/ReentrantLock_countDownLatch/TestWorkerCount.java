package com.yy.concurrent.ReentrantLock_countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试
 *
 * @author yangy
 * @time 2018-04-16 19:29
 **/
public class TestWorkerCount {

    public static void main(String[] args){
        Worker woker = new Worker("zhangsan",3);
        Worker worker2 =new Worker("lisi",2);
        CountDownLatch countDownLatch =new CountDownLatch(2);

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(new WorkerCount(woker,countDownLatch));
        executorService.submit(new WorkerCount(worker2,countDownLatch));
        executorService.shutdown();
        try {
            countDownLatch.await();
            System.out.println("all job has finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
