package com.yy.concurrent.concureent__ashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 测试hashMap
 *
 * @author yangy
 * @time 2018-04-18 11:35
 **/
public class TestConCureentHashMap {
    private static ConcurrentHashMap concurrentHashMap =new ConcurrentHashMap();

    public static void main(String[] args){
        new Thread("Thread1"){
            @Override
            public void run(){
                concurrentHashMap.put(3,33);
            }
        };
        new Thread("Thread2"){
            @Override
            public void run(){
                concurrentHashMap.put(4,33);
            }
        };
        new Thread("Thread3"){
            @Override
            public void run(){
                concurrentHashMap.put(7,33);
            }
        };
        System.out.println(concurrentHashMap);
    }


}
