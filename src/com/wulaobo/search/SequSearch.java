package com.wulaobo.search;

//线性查找
public class SequSearch {

    public static void main(String[] args) {
        int[] arr = {-9,30,3,-20,50,66,100};

        int index = sequSearch(arr,100);
        if(index==-1) {
            System.out.println("没找到：-1");
        }else{
            System.out.println("找到了,下标为:"+index);
        }

    }

    //查找数组中的值，如果找到了，返回数组下标，如果没找到，返回 -1
    public static int sequSearch(int[] arr,int value) {
        int length = arr.length;
        for(int i = 0;i<length;i++) {
            if(arr[i] == value) {
               return i;
            }
        }
        return -1;
    }

}
