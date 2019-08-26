package com.wulaobo.tree;

public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);

        System.out.println("开始前序遍历啦");
        tree.preOrder();
        System.out.println("开始中序遍历啦");
        tree.infixOrder();
    }

}


//顺序存储二叉树
class ArrBinaryTree {

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    //前序遍历
    public void preOrder(int index) {
        if (this.arr == null || this.arr.length == 0) {
            System.out.println("顺序存储二叉树为空，无法进行遍历");
        }
        System.out.println(arr[index]);

        //向左子树进行遍历
        if (2 * index + 1 < this.arr.length) {
            this.preOrder(2 * index + 1);
        }

        //向右子树进行遍历
        if (2 * index + 2 < this.arr.length) {
            this.preOrder(2 * index + 2);
        }

    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    //中序遍历
    public void infixOrder(int index) {

        if (this.arr == null || this.arr.length == 0) {
            System.out.println("顺序存储二叉树为空，无法进行遍历");
        }

        //想左遍历
        if (2 * index + 1 < this.arr.length) {
            this.infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        //向右遍历
        if (2 * index + 2 < this.arr.length) {
            this.infixOrder(2 * index + 2);
        }

    }


}


