package com.wulaobo.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);
        //前序遍历
        System.out.println("删除结点之前，前序遍历");
        binaryTree.preOrder();
        binaryTree.delHeroNodeById(5);
        System.out.println("删除结点之后，前序遍历");
        binaryTree.preOrder();
//
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
//        System.out.println("前序查找");
//        HeroNode node = binaryTree.preOrderSearch(15);
//        System.out.println(node);
//        System.out.println("中序查找");
//        HeroNode node = binaryTree.infixOrderSearch(15);
//        System.out.println(node);
//        System.out.println("后序查找");
//        HeroNode node = binaryTree.postOrderSearch(5);
//        System.out.println(node);



    }

}

//二叉树
class BinaryTree {
    private HeroNode root; //根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.root != null) {
            resNode = this.root.preOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        } else {
            System.out.println("没有找到");
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.root != null) {
            resNode = this.root.infixOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        } else {
            System.out.println("没有找到");
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.root != null) {
            resNode = this.root.postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        } else {
            System.out.println("没有找到");
            return null;
        }
    }

    public void delHeroNodeById(int id) {
        if(this.root!=null) {
            if(this.root.getId()!=id) {
                this.root.delHeroNodeById(id);
            }else{
                this.root = null;
            }
        }else{
            System.out.println("二叉树为空");
        }
    }


}

//结点
class HeroNode {

    private int id;
    private String name;
    private HeroNode left;  //左子节点，默认为空
    private HeroNode right; //右子节点，默认为空

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this); //输出当前节点
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this); //输出当前节点
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this); //输出当前节点

    }

    //前序查找
    public HeroNode preOrderSearch(int id) {
        System.out.println("前序查找啦");
        if (this.id == id) {
            return this;
        }
        HeroNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().preOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.getRight() != null) {
            resNode = this.getRight().preOrderSearch(id);
        }
        return resNode;

    }

    //中序查找
    public HeroNode infixOrderSearch(int id) {

        HeroNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().infixOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("中序查找啦");
        if (this.id == id) {
            return this;
        }
        if (this.getRight() != null) {
            resNode = this.getRight().infixOrderSearch(id);
        }
        return resNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.getRight() != null) {
            resNode = this.getRight().postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("后续查找啦");
        if (this.id == id) {
            return this;
        }
        return resNode;

    }

    public void delHeroNodeById(int id) {

        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delHeroNodeById(id);
        }
        if (this.right != null) {
            this.right.delHeroNodeById(id);
        }

    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
