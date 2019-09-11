package com.wulaobo.huffermancode;

import java.util.*;

//赫夫曼(哈夫曼)编码
public class HuffermanCode {

    static StringBuilder stringBuilder = new StringBuilder();

    static Map<Byte,String> huffermanCodes = new HashMap<>();

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        System.out.println(Arrays.toString(bytes));
        List<Node> nodes = getNode(bytes);
        Node root = createHuffermanTree(nodes);
        preOrder(root);

        getCodes(root,"",stringBuilder);
        System.out.println(huffermanCodes);

//        System.out.println(bytes.length);
    }

    private static void getCodes(Node node,String code,StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(node!=null) {
            if(node.value==null) { //非叶子结点
                //向左递归
                getCodes(node.left,"0",stringBuilder2);

                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }else{  //叶子结点
                huffermanCodes.put(node.value,stringBuilder2.toString());
            }
        }else{
            System.out.println("该赫夫曼树为空树");
        }

    }

    //哈夫曼编码压缩
    private static void zip(byte[] bytes,Map<Byte,String> huffermanCodes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b:bytes) {
            stringBuilder.append(huffermanCodes.get(b));
        }
        System.out.println(stringBuilder.toString());

    }


    public static List<Node> getNode(byte[] bytes) {
        Map<Byte,Integer> map = new HashMap<>();
        List<Node> nodes = new ArrayList<>();
        for(byte value:bytes) {
            if(map.containsKey(value)) {
                map.put(value,map.get(value)+1);
            }else{
                map.put(value,1);
            }
        }
//        System.out.println(map);
        for (Map.Entry<Byte,Integer> entry:map.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;

    }

    public static Node createHuffermanTree(List<Node> list) {
        while (list.size()>1){
            Collections.sort(list);
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);
        }
        return list.get(0);
    }

    public static void preOrder(Node root) {
        if(root!=null) {
            root.preOrder();
        }else{
            System.out.println("该哈夫曼树为空！");
        }
    }



}

class Node implements Comparable<Node>{

    Byte value;  //字符的值转成字节类型
    int weight;  //字符出现的次数

    Node left;
    Node right;

    public Node(Byte value,int weight) {
        this.value = value;
        this.weight = weight;
    }

    public void preOrder() {
        System.out.println(this);
        if(this.left!=null) {
            this.left.preOrder();
        }
        if(this.right!=null) {
            this.right.preOrder();
        }
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }
}

