package com.wulaobo.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//插入排序
public class InsertSort {

    public static void main(String[] args) {
      int[] arr = {5, -2, 78, 43,21,10};

//        int[] arr = new int[80000];
//        for (int i = 0;i<80000;i++) {
//            arr[i] = (int)(Math.random()*8000000);
//        }

        Date date1 = new Date();
        String data1Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        System.out.println("排序前:"+data1Str);

        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String data2Str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
        System.out.println("排序后:"+data2Str);

    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
//          System.out.println(Arrays.toString(arr));
        }
    }

}
