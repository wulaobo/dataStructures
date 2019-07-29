package com.wulaobo.recursion;

public class RecursionDemo {

    public static void main(String[] args) {
//        test(4);
        int res = jieCheng(4);
        System.out.println(res);
    }

    //打印问题
    public static void test(int n) {
        if(n>2)
            test(n - 1);
        else
            System.out.println("n:"+n);
    }

    //阶乘问题
    public static int jieCheng(int n) {
        int res = 1;
        if(n==1) {
            return res;
        }else{
            res =jieCheng(n - 1)*n;
        }
        return res;
    }


}
