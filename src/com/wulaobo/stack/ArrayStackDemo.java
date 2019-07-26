package com.wulaobo.stack;


public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        System.out.println("是否栈空："+stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("是否栈满："+stack.isFull());
        stack.list();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("是否栈空："+stack.isEmpty());
    }


}

//用数组来实现栈
class ArrayStack {
    private int maxSize;//设置栈的大小
    private int[] stack;  //用来存放数据
    private int top = -1;  //栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断是否栈满
    public boolean isFull() {
        return top == maxSize-1;
    }

    //判断是否栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //压栈
    public void push(int data) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = data;
    }

    //弹栈
    public int pop() {
        if(isEmpty())
            throw new RuntimeException("栈空");

        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空");
            return;
        }

        for(int i = top;i>-1;i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }


    }






}
