package com.yy.concurrent.ReentrantLock_countDownLatch;

/**
 * 工人工作类
 *
 * @author yangy
 * @time 2018-04-16 19:22
 **/
public class Worker {
    private String name;
    private long time;

    public Worker(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public void work(){
        System.out.println("name="+name +"begin");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name="+name +"end");
    }
}
