package com.wulaobo.linked;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
//        HeroNode hero5 = new HeroNode(4,"武松","行者");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);

        System.out.println("遍历双向链表");
        doubleLinkedList.list();
//        System.out.println("修改双向链表");
//        doubleLinkedList.update(hero5);
//        doubleLinkedList.list();
//        System.out.println("删除节点");
//        doubleLinkedList.delete(1);
//        doubleLinkedList.list();

    }

}

//双向链表
class DoubleLinkedList{
    //创建一个头节点
    private HeroNode head = new HeroNode(0,"","");

    //添加节点(添加在最后)
    public void add(HeroNode hero){
        //定义一个临时的，因为头节点不能动
        HeroNode temp = head;
        while (true) {
            //先判断是否为空链表
            if(temp.next==null) {
                temp.next=hero;
                hero.pre = temp;
                break;
            }
            //如果不为空链表，则指向下一个
            if(temp.next!=null) {
                temp = temp.next;
            }
        }
    }

    //遍历双向链表
    public void list() {
        HeroNode temp = head;
        if(temp.next==null) {
            System.out.println("链表为空");
        }
        while (true){
            //如果为空链表，则退出
            if(temp.next==null) {
                break;
            }
            if(temp.next!=null) {
                System.out.println(temp.next);
                temp = temp.next;
            }
        }
    }

    //修改节点
    public void update(HeroNode newHero) {
        if(head.next==null){
            System.out.println("空链表");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false; //表示是否找到节点
        while (temp!=null) {
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

    //链表的有序添加
    public void addByOrder(HeroNode hero) {
        //定义一个temp
        HeroNode cur = head.next;
        boolean flag = false;

        while (cur!=null) {
            if(cur.no>hero.no){
                break;
            }
            if(cur.no==hero.no) {
                flag = true;
                break;
            }
            cur = cur.next;

        }
        if(flag) {
            System.out.println("英雄编号重复，不能添加:"+hero.no);
        }else if(cur!=null){
            cur.pre.next = hero;
            hero.pre = cur.pre;
            hero.next = cur;
            cur.pre = hero;

        }else{
            //此时链表为空链表
            hero.pre = head;
            head.next = hero;
        }

    }


    //删除节点
    public void delete(int no) {
        if(head.next==null) {
            System.out.println("空链表");
            return;
        }
        HeroNode cur = head.next;
        boolean flag = false;//表示是否找到要删除的节点
        while(true) {
            if(cur==null) {
                break;
            }
            if(cur.no == no) {//找到了要删除节点
                flag = true;
                break;
            }
            cur = cur.next;
        }

        if(flag) {
            //temp.next = temp.next.next;
            cur.pre.next =cur.next;
            if(cur.next!=null) {
                cur.next.pre=cur.pre;
            }

        }else{
            System.out.println("没找到要删除的节点");
        }
    }



}

//英雄节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;   //指向下一个英雄节点,默认为null
    public HeroNode pre;    //指向前一个英雄节点，默认为null

    public HeroNode(int no,String name,String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}