package com.wulaobo.stack;

public class LinkedListStackDemo {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        LinkedListStack linkedListStack = new LinkedListStack();
        System.out.println(linkedListStack.isEmpty());
        linkedListStack.push(node1);
        linkedListStack.push(node2);
        linkedListStack.push(node3);
        System.out.println("开始弹栈啦");
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
//        linkedListStack.list();

    }

}

//使用没有头节点的链表来实现栈
class LinkedListStack {

    //定义一个初始长度为0的数组来缓存数据
    Node head = null;
    int length = 0;//结点个数

    //判断是否栈空
    public boolean isEmpty() {
        return head==null;
    }

    //压栈
    public void push(Node node) {
        if(head==null) { //空链表
            head = node;
            length++;
            return;
        }
        Node cur = head;
       for(int i = 0;i<length;i++) {
           if(cur.next==null) {
               cur.next = node;
               length++;
               break;
           }
           cur = cur.next;
       }

    }

    //弹栈
    public int pop() {
        if(isEmpty())
            throw new RuntimeException("栈空");
        Node cur = head;
        for(int i = 0;i<length-1;i++) {
            cur = cur.next;
        }
        int value = cur.data;
        length--;
        return value;
    }

//    //遍历栈
//    public void list() {
//        if(isEmpty()) {
//            System.out.println("栈空");
//            return;
//        }
//        Node cur = head.next;
//        //构建一个新的链表
//        Node newList = new Node();
//        newList.data = cur.data;
//        Node next = null; //指向下一个节点
//        //逆转链表
//        while (cur!=null) {
//            next = cur.next;
//            cur.next = newList.next;
//            newList.next = cur;
//            cur = next;
//        }
//        for(int i = 0;i<length;i++) {
//            System.out.println(newList.data);
//            newList = newList.next;
//        }
//
//
//    }



}

 class Node {
    int data;  //存储数据
    Node next;  //指向下一个节点

     public Node(){}

    public Node(int e) {
        this.data = e;
    }
}


