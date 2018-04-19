package com.yy.datastructure.stack;

/**
 * 数据栈
 *
 * @author yangy
 * @time 2018-04-16 16:52
 **/
public class Strack {
    int[] array;
    int length;
    int top;

    public Strack(int size) {
        this.array = new int[size];
        this.length = size;
        this.top = -1;
    }
    public int push(int a){
        return array[++top] = a;
    }
    /*存在内存泄露的问题，当我们用pop方法弹出栈中的对象时，该对象不会被当作垃圾回收，
    即使使用栈的程序不再引用这些对象，因为栈内部维护着对这些对象的过期引用（obsolete reference）。
    在支持垃圾回收的语言中，内存泄露是很隐蔽的，这种内存泄露其实就是无意识的对象保持*/
    public int pop(){
        return array[top--];
    }
    public int peek(){
        return array[top];
    }
    public boolean isFull(){
        return top == length-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public static void main(String[] args){
        Strack stack = new Strack(2);
        stack.push(10);
        stack.pop();
        stack.push(10);
        System.out.println(stack.isFull());

        stack.pop();
        System.out.println(stack.isEmpty());

    }
}
