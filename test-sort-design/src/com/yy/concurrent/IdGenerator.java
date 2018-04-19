package com.yy.concurrent;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ID生成器
 *
 * @author yangy
 * @time 2018-04-16 18:02
 **/
public class IdGenerator {
    private final AtomicLong sequenceNumber = new AtomicLong(0);
    Lock accountLock = new ReentrantLock();
    public long next(){
        return sequenceNumber.getAndIncrement();
    }
    
    public static void main(String[] args){
        IdGenerator idGenerator = new IdGenerator();
        long next = idGenerator.next();
        next =idGenerator.next();
        System.out.println(next);
    }
}
