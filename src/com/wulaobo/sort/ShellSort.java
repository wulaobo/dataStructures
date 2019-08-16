package com.wulaobo.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//希尔排序
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        int[] arr = new int[80000];
        for (int i = 0;i<80000;i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        String data1Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        System.out.println("排序前:"+data1Str);

        shellSort(arr);
//        System.out.println("排序后:"+Arrays.toString(arr));
        Date date2 = new Date();
        String data2Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
        System.out.println("排序后:"+data2Str);

    }

    public static void shellSort(int[] arr){

        //第一次排序
        int temp = 0;
        int count = 0;
        for(int gap = arr.length/2;gap>0;gap /=2){
            for(int i = gap;i<arr.length;i++) {
                for(int j = i-gap;j>=0;j-=gap) {
                    if(arr[j]>arr[j+gap]){
                        temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
//            System.out.println("第"+(++count)+"趟排序:"+ Arrays.toString(arr));
        }



//        //第二次排序
//        for(int i = 2;i<arr.length;i++) {
//            for(int j = i-2;j>=0;j-=2) {
//                if(arr[j]>arr[j+2]){
//                    temp = arr[j+2];
//                    arr[j+2] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//
//        System.out.println("第二趟排序:"+ Arrays.toString(arr));
//
//
//        //第二次排序
//        for(int i = 1;i<arr.length;i++) {
//            for(int j = i-1;j>=0;j-=1) {
//                if(arr[j]>arr[j+1]){
//                    temp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//
//        System.out.println("第三趟排序:"+ Arrays.toString(arr));


    }


}
