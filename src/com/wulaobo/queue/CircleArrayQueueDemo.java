package com.wulaobo.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        System.out.println("这是环形队列。。。。");
        //队列为4，但是有效数据却只能为3，原因是需要空出一个空间
        CircleArrayQueue queue = new CircleArrayQueue(4);//只能装3个数

        char key=' ';//接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            //String res = sc.next();
            System.out.println("q(getQueueList):遍历队列");
            System.out.println("g(get):获取数据");
            System.out.println("a(add):添加数据");
            System.out.println("h(getHead):获得队列头数据");
            System.out.println("e(exit):退出程序");

            key = sc.next().charAt(0);
            switch (key) {
                case 'q':
                    try {
                        queue.getQueueList();
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

//环形队列
class CircleArrayQueue{

    private int maxSize;  //定义队列最大保存的个数
    //指向队列的第一个元素，初始值为0
    private int front;
    //指向队列的最后一个元素的后一个位置，初始值为0
    private int rear;
    private int[] array;  //用于保存数据

    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear==front;
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear+1)%maxSize==front;
    }

    //添加数据
    public void add(int data) {
        if(isFull()) {
            throw new RuntimeException("队列满了，存不了数据啦");
        }
        array[rear]=data;
        rear=(rear+1)%maxSize;

    }

    //取数据
    public int get() {
        if(isEmpty()) {
            throw new RuntimeException("队列是空的，取不了数据啦");
        }

        int temp = array[front];
        front=(front+1)%maxSize;
        return temp;
    }

    //获得队列头数据
    public int getHead() {
        if(isEmpty()) {
            throw new RuntimeException("队列是空的，取不了数据啦");
        }
        return array[front];
    }

    //遍历队列
    public void getQueueList() {
        if(isEmpty()) {
            throw new RuntimeException("队列是空的，取不了数据啦");
        }

        for(int i = front;i<front+size();i++) {
            System.out.printf("array[%d]=%d\n",i%maxSize,array[i%maxSize]);
        }

    }


    //获得队列有效数据的个数
    public int size() {
        return (rear+maxSize-front)%maxSize;
    }




}