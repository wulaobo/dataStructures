package com.wulaobo.search;

import java.util.ArrayList;
import java.util.List;

//二分查找：二分查找必须是有序的
public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = {-3, 5, 17, 13, 17, 17, 17, 21, 33, 101,17,17};
//        int findIndex = binarySearch(arr, 0, arr.length - 1, 100);
//        System.out.println("索引值为：" + findIndex);
//        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 17);
//        System.out.println(list);

        int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int index = binarySearch(arr,0,arr.length-1,77);
        System.out.println(index);


    }

    //查找单个值
    public static int binarySearch(int[] arr, int left, int right, int findValue) {
        System.out.println("aaa");
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (findValue > midValue) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }

    }


    //查找所有的值
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findValue) {

        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (findValue > midValue) {
            return binarySearch2(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return binarySearch2(arr, left, mid - 1, findValue);
        } else {

            List<Integer> list = new ArrayList<>();

            //向左找
            int temp = mid - 1;
            while (true) {
                if (temp < 0) {
                    break;
                }

                if(arr[temp]==findValue){
                    list.add(temp);
                }
                temp -= 1;

            }

            list.add(mid);

            //向右查找
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1) {
                    break;
                }
                if(arr[temp]==findValue){
                    list.add(temp);
                }
                temp += 1;

            }

            return list;

        }


    }


}
