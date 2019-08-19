package com.wulaobo.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//基数排序(桶排序)
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0;i<8000000;i++) {
            arr[i] = (int) (Math.random()*8000000);
        }

        Date date1 = new Date();
        String date1Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        System.out.println("排序前："+date1Str);
        radixSort(arr);

        Date date2 = new Date();
        String data2Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
        System.out.println("排序后:"+data2Str);

//        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {

        int length = arr.length;

        //定义桶
        int[][] bucket = new int[10][length];

        int[] bucketElementCounts = new int[10];

        //找出数组arr中最大的值
        int max = arr[0];
        for (int i = 1;i<length;i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }

        int elementLength = (max+"").length();

        for(int a = 0,b = 1;a<elementLength;a++,b *= 10) {

            //取arr数组中的个位数
            for(int i = 0;i<length;i++) {
                int k = arr[i] / b % 10;  //个位数
                bucket[k][bucketElementCounts[k]] = arr[i];
                bucketElementCounts[k] +=1;
            }
            int n = 0;
            //取出桶中的元素
            for (int i = 0; i< bucket.length;i++){
                if(bucketElementCounts[i]>0) {
                    for(int j = 0;j<bucketElementCounts[i];j++) {
                        arr[n] = bucket[i][j];
                        n++;
                    }
                }
                bucketElementCounts[i] = 0;
            }
        }

    }

}
