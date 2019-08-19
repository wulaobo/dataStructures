package com.wulaobo.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//归并排序
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        int[] arr = new int[8000000];
        for (int i = 0;i<8000000;i++) {
            arr[i] = (int) (Math.random()*8000000);
        }

        Date date1 = new Date();
        String date1Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        System.out.println("排序前："+date1Str);

        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);

        Date date2 = new Date();
        String data2Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
        System.out.println("排序后:"+data2Str);

//        System.out.println(Arrays.toString(arr));

    }

    //分解+合并
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int middle = (left + right) / 2;

            //向左分解
            mergeSort(arr, left, middle, temp);
            //向右分解
            mergeSort(arr, middle + 1, right, temp);

            merge(arr, left, middle, right, temp);
        }

    }

    //合并
    public static void merge(int[] arr, int left, int middle, int right, int[] temp) {
//        System.out.println("😀");
        int i = left;
        int j = middle + 1;
        int t = 0;

        while (i <= middle && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i += 1;
                t += 1;
            } else {
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }

        }

        //右边的数小于左边的数
        while (j <= right) {
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }

        //左边的数小于等于右边的数
        while (i <= middle) {
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }

        //将temp中的数据拷贝到arr数组中
        t = 0;
        int tempLeft = left;
//        System.out.println("tempLeft="+tempLeft+"，right="+right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }

}
