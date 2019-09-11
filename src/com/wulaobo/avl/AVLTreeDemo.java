package com.wulaobo.avl;

//平衡二叉树案例
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        System.out.println("中序遍历平衡二叉树");
        avlTree.infixOrder();
        System.out.println("平衡二叉树的高度是：" + avlTree.getRoot().height());
        System.out.println("平衡二叉树的左子树的高度是：" + avlTree.getRoot().leftHeight());
        System.out.println("平衡二叉树的右子树的高度是：" + avlTree.getRoot().rightHeight());
        System.out.println("根节点是：" + avlTree.getRoot());

    }

}

//平衡二叉树
class AVLTree {
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

    public Node getRoot() {
        return root;
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

    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    //求树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转
    public void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;

    }

    //右旋转
    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;

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

        //如果右节点的高度 - 左结点的高度大于1，就左旋转
        if (this.rightHeight() - this.leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                //右旋转
                rightRotate();
            } else {
                rightRotate();
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








