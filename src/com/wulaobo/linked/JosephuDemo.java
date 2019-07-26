package com.wulaobo.linked;

//约瑟夫问题
public class JosephuDemo {
    public static void main(String[] args) {
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.addBoy(5);
        singleCircleLinkedList.showList();
        singleCircleLinkedList.countBoy(1,2,5);

    }

}

//单向环形链表
class SingleCircleLinkedList{
    private Boy first = null;

    //添加小孩
    public void addBoy(int nums) {
        if(nums<1) {
            System.out.println("nums的值不符合要求");
        }
        Boy curBoy = null;
        for(int i = 1;i<=nums;i++) {
           if(i==1) {
               curBoy = new Boy(i);
               first = curBoy;  //创造第一个节点
               first.setNext(first);
           }else{
               Boy boy = new Boy(i);
               curBoy.setNext(boy);
               boy.setNext(first);
               curBoy = boy;

           }
        }

    }

    //遍历小孩节点
    public void showList() {
        if(first==null) {
            System.out.println("链表为空");
            return;
        }
        //头节点不能动
        Boy curBoy = first;

        while (curBoy!=null) {
            System.out.println("小孩的节点为:"+curBoy.getNo());
            if(curBoy.getNext()==first){
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    /**
     * 小孩出圈的顺序
     * @param startNo：定义从第几个小孩开始数
     * @param countNo：定义每次数几个
     * @param nums：定义小孩的个数
     */
    public void countBoy(int startNo,int countNo,int nums) {
        //对于输入的参数进行校验
        if(startNo<1||nums<1 || countNo<1||startNo>nums) {
            System.out.println("输入的参数无效");
            return;
        }
        Boy helper = first.getNext();
        //让helper指向循环链表的最后一个节点(孩子)
        while (true){
              if(helper.getNext()==first) {
                  break;
              }
              helper = helper.getNext();
        }
        //此时helper指向循环链表的最后一个节点，再移动 k-1次
        for(int i = 0;i<startNo-1;i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //此时startNo和helper就指向了第k个节点
        while (true) {
            if(helper==first) {
                //此时循环链表中只剩下一个节点
                break;
            }

            for (int j = 0;j<countNo-1;j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("输出的节点是:"+first.getNo());
            first = first.getNext();
            helper.setNext(first);

        }
        System.out.println("最后一个节点是:"+first.getNo());

    }


}


//小孩节点
class Boy{
    private int no;  //小孩编号
    private Boy next; //指向下一个小孩

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }

}
