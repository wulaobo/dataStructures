package com.wulaobo.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key=' ';//接收用户输入
        Scanner  sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            //String res = sc.next();
            System.out.println("q(getQueue):遍历队列");
            System.out.println("g(get):获取数据");
            System.out.println("a(add):添加数据");
            System.out.println("h(getHead):获得队列头数据");
            System.out.println("e(exit):退出程序");

            key = sc.next().charAt(0);
            switch (key) {
                case 'q':
                    try {
                        queue.getQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int data =queue.get();
                        System.out.println("取出的数据是："+data);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数：");
                        int value = sc.nextInt();
                        queue.add(value);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                     try {
                         int value = queue.getHead();
                         System.out.println("队列头是："+value);
                     }catch (Exception e) {
                         System.out.println(e.getMessage());
                     }
                    break;
                case 'e':
                    loop=false;
                    sc.close();
                    break;
                default:
                    break;

            }

        }

        System.out.println("程序退出！");


    }


}

class ArrayQueue {

    private int[] array;   //队列数组，用来存取数据
    private int front;   //队列头，指向队列数据的前一个位置
    private int rear;    //对列尾，指向队列
    private int maxSize;  //队列数据的最大个数


    public ArrayQueue(int maxSize) {
        this.maxSize=maxSize;
        this.array = new int[this.maxSize];
        this.front=-1;
        this.rear=-1;
    }

    //判断队列是否满了
    public boolean isFull() {
        return rear==this.maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        if(front==rear){
            return true;
        }
        return false;
    }

    //获取数据
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列是空的,没有数据。。。");
        }
        front++;
        return array[front];
    }

    //添加数据
    public void add(int data) {
        if(isFull()) {
            throw new RuntimeException("队列是满的,不能添加数据");
        }
        rear++;
        array[rear]=data;
    }

    //获得队列头
    public int getHead() {
        if(isEmpty()){
            throw new RuntimeException("队列是空的,没有数据。。。");
        }
        return array[front+1];
    }

    //遍历队列
    public void  getQueue() {
        if(isEmpty()){
            throw new RuntimeException("队列是空的,没有数据。。。");
        }
        for(int i =0;i<array.length;i++){
            System.out.print("\t"+array[i]);
        }
        System.out.println();
    }



}

