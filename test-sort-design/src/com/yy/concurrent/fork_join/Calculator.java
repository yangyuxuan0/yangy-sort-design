package com.yy.concurrent.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 测试forkjoin框架
 *
 * @author yangy
 * @time 2018-04-17 20:16
 **/
public class Calculator extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 10;
    private int start;
    private int end;

    public Calculator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum =0;

        if(end -start <THRESHOLD){
            for (int i = start; i <=end ; i++) {
                sum+=i;
            }
        }else{
           int moddle = (end + start)>>>1;
            Calculator leftCa = new Calculator(start, moddle);
            Calculator rightCa = new Calculator(moddle + 1, end);
            leftCa.fork();
            rightCa.fork();
            sum = leftCa.join() + rightCa.join();
        }

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(new Calculator(1, 10000));
        System.out.println(submit.get());

    }
}
