package com.yy.concurrent.TransferQueue;

import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * 测试transferqueue
 *
 * @author yangy
 * @time 2018-04-18 10:00
 **/
public class TestTransferQueue {

    private static TransferQueue<String> transferQueue = new LinkedTransferQueue<>();

    public static void main(String[] args){

        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 10, 1000, TimeUnit.HOURS, new LinkedBlockingDeque<>());
        new Consumer().start();
        new Productor(1).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over.size="+ transferQueue.size());
    }

    static class Productor extends Thread{
        private int id;

        public Productor(int id) {
            this.id = id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            String result = id+"";
            System.out.println("begin="+result);
            try {
                transferQueue.transfer(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end="+result);

        }
    }
    static  class Consumer extends Thread{
        @Override
        public void run() {
            String poll = transferQueue.poll();
            System.out.println("over.size="+transferQueue.size());
        }
    }
}
