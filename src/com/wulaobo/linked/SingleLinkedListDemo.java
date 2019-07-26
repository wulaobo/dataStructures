package com.wulaobo.linked;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        Hero hero1 = new Hero(1,"宋江","及时雨");
        Hero hero2 = new Hero(2,"卢俊义","玉麒麟");
        Hero hero3 = new Hero(3,"吴用","智多星");
        Hero hero4 = new Hero(4,"林冲","豹子头");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero3);
        linkedList.add(hero2);
        linkedList.add(hero4);
        System.out.println("添加后：");
        linkedList.list();
//        System.out.println("反转单链表后：");
//        linkedList.reverse();
//        linkedList.list();

        System.out.println("逆序打印单链表:");
        linkedList.reverseLinkedList();
        System.out.println("添加后：");
        linkedList.list();

//        linkedList.addByOrder(hero1);
//        linkedList.addByOrder(hero4);
//        linkedList.addByOrder(hero3);
////        linkedList.addByOrder(hero3);
//        linkedList.addByOrder(hero2);
//        linkedList.delete(1);
//        System.out.println("有效节点的个数是:"+linkedList.getLength(linkedList.getHead()));
//        linkedList.list();
//        System.out.println("============================");
//        System.out.println(linkedList.searchKHero(linkedList.getHead(),0));
//        System.out.println("单链表修改后---");
//        linkedList.update(new Hero(5,"小卢","玉麒麟~~~"));
//        System.out.println("单链表删除节点后~~~");
//        linkedList.delete(1);
//        linkedList.delete(2);
//        linkedList.delete(3);
//        linkedList.delete(4);
//        System.out.println("查找单链表的节点");
//        System.out.println(linkedList.find(1));
//        linkedList.list();
    }


    
}

//单链表
class SingleLinkedList {

    //头节点
    private Hero head = new Hero(0,"","");

    public Hero getHead() {
        return head;
    }

    //添加元素
    public void add(Hero hero){
        //定义一个临时的，因为头节点不能动
        Hero temp = head;

        while (true) {
            //先判断是否为空链表
            if(temp.next==null) {
                temp.next=hero;
                break;
            }
            //如果不为空链表，则指向下一个
            if(temp.next!=null) {
                temp = temp.next;
            }
        }
    }

    //链表的有序添加
    public void addByOrder(Hero hero) {
        //定义一个temp
        Hero temp = head;
        boolean flag = false;

        while (true) {
            if(temp.next==null) {
                break;
            }
            if(temp.next.no>hero.no){
                break;
            }
            if(temp.next.no==hero.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if(flag) {
            System.out.println("英雄编号重复，不能添加:"+hero.no);
        }else{
            hero.next = temp.next;
            temp.next = hero;
        }

    }

    //修改英雄节点
    public void update(Hero newHero) {
        if(head.next==null){
            System.out.println("空链表");
            return;
        }
        Hero temp = head.next;
        boolean flag = false; //表示是否找到节点
        while (true) {
            if(temp==null) {//如果没找到该节点
                break;
            }
            if(temp.no==newHero.no) {
                //找到节点了
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.name = newHero.name;
            temp.nickName = newHero.nickName;
        }else{
            System.out.println("没找到该节点:"+newHero.no);
        }

    }

    //删除该节点
    public void delete(int no) {
        if(head.next==null) {
            System.out.println("空链表");
            return;
        }
        Hero temp = head;
        boolean flag = false;//表示是否找到要删除的节点
        while(true) {
            if(temp.next==null) {
                break;
            }
            if(temp.next.no == no) {//找到了要删除节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.next = temp.next.next;
        }else{
            System.out.println("没找到要删除的节点");
        }
    }

    //查找节点
    public Hero find(int no) {
        if(head.next==null) {
            System.out.println("空链表");
            return null;
        }
        Hero temp = head.next;
        boolean flag = false;

        while (true) {
            if(temp==null) {
                break;
            }
            if(temp.no ==no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            return temp;
        }else{
            System.out.println("没有找到该节点");
        }
        return null;
    }


    //显示链表
    public void list() {
        Hero temp = head;
        if(temp.next==null) {
            System.out.println("链表为空");
        }
        while (true){
            //如果为空链表，则退出
            if(temp.next==null) {
                return;
            }

            if(temp.next!=null) {
                System.out.println(temp.next);
                temp = temp.next;
            }
        }
    }

    //求单链表中有效节点的个数
    public int getLength(Hero head) {
         int length = 0;
         if(head.next==null) {
             System.out.println("空链表");
             return 0;
         }

         Hero cur = head.next;
         while (cur!=null) {
             length++;
             cur = cur.next;
         }
        return length;
    }

    //查找单链表中的倒数第k个节点
    public Hero searchKHero(Hero head,int index) {
        if(head.next==null) {
            System.out.println("空链表");
            return null;
        }
        //获得单链表的有效个数(有效个数是指不包括头节点的元素个数)
        int size = getLength(head);
        if(index<=0||index>size) {
            return null;
        }
        Hero cur = head.next;
        for(int i = 0;i<size-index;i++) {
            cur = cur.next;
        }

        return cur;
    }

    //单链表反转
    public void reverse() {
        Hero reverseHead = new Hero(0,"","");
        if(head.next==null||head.next.next==null) {
            return;
        }
        Hero cur = head.next;  //指向当前节点
        Hero next=null;  //当前节点的下一个节点
        while (cur!=null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;

        }
        head.next = reverseHead.next;

    }

    //逆序遍历单链表
    public void reverseLinkedList() {
        if(head.next==null) {
            System.out.println("空链表");
            return;
        }

        Hero cur = head.next;
        Stack<Hero> stack = new Stack<>();
        while (cur!=null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }



}


class Hero{
    public int no;
    public String name;
    public String nickName;
    public Hero next;   //指向下一个英雄

    public Hero(int no,String name,String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

