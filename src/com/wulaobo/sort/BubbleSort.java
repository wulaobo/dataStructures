package com.wulaobo.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr =new int[8000];
//          int[] arr = {5,4,3,2,1};
        for(int i = 0;i<8000;i++) {
            arr[i] = (int) (Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str =sdf.format(date1);
        System.out.println("排序前的时间是:"+date1Str);


        int length = arr.length;
        int temp = 0;
        boolean flag = false;
        for(int i = 0;i<length-1;i++) {
            for (int j = 0;j<length-1-i;j++) {
                if(arr[j]>arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

//            System.out.println("第"+(i+1)+"趟排序的结果为："+ Arrays.toString(arr));

            if(!flag) {
                break;
            }else{
                flag = false;
            }


        }


        Date date2 = new Date();
       // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str =sdf.format(date2);
        System.out.println("排序后的时间是:"+date2Str);

    }

}
