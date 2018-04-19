package com.yy.concurrent.CopyOnWriteArrayList;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * test
 *
 * @author yangy
 * @time 2018-04-16 19:59
 **/
public class TestCopyOnWriteArrayList implements Runnable{
    private CopyOnWriteArrayList arrayList;

    public TestCopyOnWriteArrayList(CopyOnWriteArrayList arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(Math.random());
        }
    }

    public static void main(String[] args){
        //ArrayList arrayList=new ArrayList();
        CopyOnWriteArrayList arrayList=new CopyOnWriteArrayList();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new TestCopyOnWriteArrayList(arrayList));
        executorService.execute(new TestCopyOnWriteArrayList(arrayList));
        executorService.shutdown();
        System.out.println("ok");
        String a="";
    }
}
