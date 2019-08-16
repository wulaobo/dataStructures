package com.wulaobo.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//选择排序
public class SelectSort {

    public static void main(String[] args) {
//        int[] arr = {5,4,3,2,1};
        int[] arr = new int[80000];
        for (int i = 0;i<arr.length;i++) {
             arr[i] = (int) (Math.random()*8000000);
        }

        Date date1 = new Date();
        String date1Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        System.out.println("排序前的时间为："+date1Str);

        selectSort(arr);
        Date date2 = new Date();
        String date2Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
        System.out.println("排序后的时间为："+date2Str);
//        System.out.println("排序后的结果为:"+ Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        int length = arr.length;
        //外层循环表示循环的趟数
        for(int i = 0;i<length-1;i++) {
            //默认第一个元素为最小值
            int min = arr[i];
            int minIndex = i;
            for(int j = i+1;j<length;j++) {
                if(arr[j]<min) {
                    min = arr[j];
                    minIndex = j;

                }
            }
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第"+(i+1)+"趟："+Arrays.toString(arr));

        }
    }


}
