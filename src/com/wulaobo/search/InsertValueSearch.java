package com.wulaobo.search;

import java.util.Arrays;

//插值查找：要求查找的数是有序的
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int index = insertValueSearch(arr,0,arr.length-1,77);

        System.out.println(index);

//        System.out.println(Arrays.toString(arr));
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        System.out.println("xxx");
        if (left > right || findValue < arr[left] || findValue > arr[right]) {
            return -1;
        }

        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);

        //向右查找
        if(findValue>arr[mid]) {
            return insertValueSearch(arr,mid+1,right,findValue);
        }else if(findValue<arr[mid]) {
            return insertValueSearch(arr,left,mid-1,findValue);
        }else {
            return mid;
        }

    }


}
