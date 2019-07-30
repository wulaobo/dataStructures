package com.wulaobo.recursion;

//8皇后问题
public class Queue8 {

    int max = 8;
    int[] array = new int[max];
    static int count;
    static int judgeCount;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("共有%d种解法",count);
        System.out.println();
        System.out.printf("总共判断了%d次",judgeCount);
    }

    public void check(int n) {
        if(n==max) {
            print();
            count++;
            return;
        }
        for (int i = 0;i<max;i++) {
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }

    }


    //判断是否冲突 即第n个皇后与前面n-1个皇后进行比较
    private boolean judge(int n){
        judgeCount++;
        for(int i = 0;i<n;i++) {
            if(array[i]==array[n]|| Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    //打印数组
    private void print() {
        for (int i = 0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


}
