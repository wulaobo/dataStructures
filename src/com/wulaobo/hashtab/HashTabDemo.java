package com.wulaobo.hashtab;

import java.util.Scanner;

public class HashTabDemo {

    public static void main(String[] args) {

        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加员工");
            System.out.println("list:遍历员工");
            System.out.println("exit:退出");
            String key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入员工id：");
                    int id = scanner.nextInt();
                    System.out.println("请输入员工姓名：");
                    String name = scanner.next();
                    hashTab.add(new Emp(id,name));
                    System.out.println("添加成功");
                    break;
                case "list":
//                    System.out.println("展示员工列表：");
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;

            }
        }

    }

}

class HashTab {

    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for(int i = 0;i<size;i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }

    }

    //添加员工
    public void add(Emp emp) {
        int index = hash(emp.getId());
        empLinkedListArray[index].add(emp);
    }

    //遍历员工集合
    public void list() {
        for(int i = 0;i<size;i++) {
            if(empLinkedListArray[i].head!=null) {
                empLinkedListArray[i].list(i);
            }
        }
    }

    //哈希函数
    public int hash(int id) {
        return id % size;
    }


}

class EmpLinkedList {

    public Emp head;  //头指针

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = emp;
                break;
            }
            temp = temp.next;
        }

    }

    public void list(int no) {
        System.out.println("开始遍历链表：");
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Emp temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.print("第"+(no+1)+"号链表");
            System.out.println(",id=" + temp.getId() + ",name=" + temp.getName());
            temp = temp.next;
        }

    }


}

class Emp {

    private int id;
    private String name;
    public Emp next;

    public Emp() {
    }

    public Emp(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

