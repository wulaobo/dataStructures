package com.wulaobo.binarysorttree;

//二叉排序树案例
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        int length = arr.length;
        BinarySortTree bst = new BinarySortTree();
        for (int i = 0; i < length; i++) {
            bst.add(new Node(arr[i]));
        }
        System.out.println("中序遍历：");
        bst.infixOrder();
        System.out.println("删除结点后：");
        bst.delNode(1);
        bst.delNode(2);
        bst.delNode(10);
        bst.delNode(9);
        bst.delNode(12);
        bst.delNode(3);
        bst.delNode(7);
        bst.delNode(5);


        bst.infixOrder();
    }

}


class BinarySortTree {
    Node root;  //根结点

    //添加方法
    public void add(Node node) {
        if (this.root != null) {
            this.root.add(node);
        } else {
            this.root = node;
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空的二叉排序树");
        }
    }

    //查找目标结点
    public Node searchTargetNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchTargetNode(value);
        }
    }

    //查找目标结点的父节点
    public Node searchTargetNodeParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchTargetNodeParent(value);
        }
    }

    //删除一颗二叉排序树的值最小的结点，并将结点的值返回
    public int delNodeMin(Node node) {
        Node target = node;

        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = searchTargetNode(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;//此时目标结点就是根节点
                return;
            }

            Node targetNodeParent = searchTargetNodeParent(value);
            //目标结点为叶子结点，且父节点只有一个结点

            if (targetNode.left == null && targetNode.right == null) {   //目标结点为叶子节点
                if (targetNodeParent.left != null && targetNodeParent.left.value == value) {
                    targetNodeParent.left = null;
                }
                if (targetNodeParent.right != null && targetNodeParent.right.value == value) {
                    targetNodeParent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {  //目标结点左右子树都不为空
                int minValue = delNodeMin(targetNode.right);
                targetNode.value = minValue;
            } else { //目标节点只有一个左子树或只有一个右子树
                if (targetNode.left != null) {
                    if (targetNodeParent != null) {
                        if (targetNodeParent.left != null && targetNodeParent.left.value == value) {
                            targetNodeParent.left = targetNode.left;
                        } else {
                            targetNodeParent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                }
                if (targetNode.right != null) {
                    if (targetNodeParent != null) {
                        if (targetNodeParent.left != null && targetNodeParent.left.value == value) {
                            targetNodeParent.left = targetNode.right;
                        } else {
                            targetNodeParent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }

            }

        }
    }

}

//结点类
class Node {
    int value;
    Node left;  //左子结点
    Node right;  //右子结点

    public Node(int value) {
        this.value = value;
    }

    //查找目标结点
    public Node searchTargetNode(int value) {
        if (this.value == value) {
            return this;
        } else {
            //向左查找
            if (this.left != null && this.value > value) {
                return this.left.searchTargetNode(value);
            }
            //向右查找
            if (this.right != null && this.value <= value) {
                return this.right.searchTargetNode(value);
            }
            return null;
        }

    }

    //查找目标结点的父节点
    public Node searchTargetNodeParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && this.value > value) {  //向左查找
                return this.left.searchTargetNodeParent(value);
            } else if (this.right != null && this.value <= value) {
                return this.right.searchTargetNodeParent(value);
            } else {
                return null;
            }

        }
    }

    //添加结点
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (this.value > node.value) {
            //向左添加
            if (this.left == null) {
                this.left = node;
            } else {
                //向左递归添加
                this.left.add(node);
            }

        } else {
            //向右添加
            if (this.right == null) {
                this.right = node;
            } else {
                //向右递归
                this.right.add(node);
            }
        }

    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
