package com.wulaobo.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//赫夫曼树(哈夫曼树)的案例
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node node = huffermanSort(arr);
        preOrder(node);
    }

    //前序遍历
    public static void preOrder(Node root) {
        if(root!=null) {
            root.preOrder();
        }else{
            System.out.println("该哈夫曼树为空树");
        }
    }

    public static Node huffermanSort(int[] arr) {

        List<Node> nodes = new ArrayList();

        for(int value:arr) {
            nodes.add(new Node(value));
        }


//        System.out.println("排序：");
//        System.out.println("排序："+nodes);

        while (nodes.size()>1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.getValue()+rightNode.getValue());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
//        System.out.println("哈夫曼树："+nodes.get(0));
        return nodes.get(0);
    }


}

//为了让Node可以排序，必须要实现Comparable接口
class Node implements Comparable<Node>{

    private int value; //结点的值
    private Node left;  //左子结点
    private Node right; //右子结点

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left!=null) {
            this.left.preOrder();
        }
        if(this.right!=null) {
            this.right.preOrder();
        }

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}