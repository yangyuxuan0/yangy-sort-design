package com.yy.concurrent.ReentrantLock_countDownLatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * 统计完成情况类
 *
 * @author yangy
 * @time 2018-04-16 19:24
 **/
public class WorkerCount implements Callable<Integer>{

    private Worker worker;
    private CountDownLatch countDownLatch;

    public WorkerCount(Worker worker, CountDownLatch countDownLatch) {
        this.worker = worker;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public Integer call() throws Exception {
        worker.work();
            countDownLatch.countDown();

        return 0;
    }
}
