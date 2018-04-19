package com.yy.datastructure.queue;

import java.util.Arrays;

/**
 * 循环队列之数组实现
 *
 * @author yangy
 * @time 2018-04-17 15:06
 **/
public class QueueArray {
    private int[] array;
    private int maxSize;
    /**
     * the start of queue
     */
    private int front;
    /**
     * the end of queue
     */
    private int real;
    private int nItems;

    public QueueArray(int maxSize) {
        this.array = new int[maxSize];
        this.front = 0;
        this.real = -1;
        this.maxSize = maxSize;
        this.nItems = 0;
    }

    public void insert(int value){
        if(isFull()){
            throw new RuntimeException("---");
        }
        if(real == maxSize-1){
            real = 0;
        }
        array[++real] = value;
            nItems++;
    }

    public int remove(){
        if(isEmpty()){
            throw new RuntimeException("---");
        }
        int temp = array[front++];
        if(front == maxSize){
           front = 0;
        }
        nItems--;
        return temp;
    }

    public int peek(){
        return array[front];
    }
    public boolean isEmpty(){
        return  nItems == 0;
    }
    public boolean isFull(){
        return nItems == maxSize;
    }
    public String getQueue(){
        return Arrays.toString(array);
    }
    public static void main(String[] args){
        QueueArray queueArray =new QueueArray(4);
        try {
            queueArray.insert(2);
            queueArray.insert(7);
            queueArray.insert(9);
            queueArray.insert(3);
            queueArray.insert(5);
        }catch (Exception e){

        }
        System.out.println(queueArray.getQueue());

    }
}
