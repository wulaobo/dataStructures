package com.wulaobo.tree.threadedbinarytree;

//线索化二叉树的案例
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node3 = new HeroNode(3, "jack");
        HeroNode node6 = new HeroNode(6, "lucy");
        HeroNode node8 = new HeroNode(8, "marry");
        HeroNode node10 = new HeroNode(10, "mike");
        HeroNode node14 = new HeroNode(14, "john");
        ThreadedBinaryTree tree = new ThreadedBinaryTree();

        root.setLeft(node3);
        root.setRight(node6);
        node3.setLeft(node8);
        node3.setRight(node10);
        node6.setLeft(node14);
        tree.setRoot(root);

        tree.threadedHeroNodes(root);
        tree.threadedList();
//        System.out.println(node14.getLeft());
//        System.out.println(node14.getLeftType());
//        System.out.println(node14.getRight());
//        System.out.println(node14.getRightType());

    }

}

//线索化二叉树
class ThreadedBinaryTree {
    private HeroNode root; //根节点

    private HeroNode pre; //当前结点的前驱结点

    //中序线索化二叉树
    public void threadedHeroNodes(HeroNode node) {
        if (node == null) {
            return;
        }

        //向左递归
        if(node.getLeft()!=null){
            this.threadedHeroNodes(node.getLeft());
        }

        //当前结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        //向右递归
        if(node.getRight()!=null) {
            this.threadedHeroNodes(node.getRight());
        }

    }

    //线索化遍历二叉树
    public void threadedList() {
        HeroNode node = this.root;
        while (node!=null) {

            while (node.getLeftType()==0) {
                node = node.getLeft();
            }
            System.out.println(node);

            while (node.getRightType()==1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();

        }

    }


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
        if (this.root != null) {
            if (this.root.getId() != id) {
                this.root.delHeroNodeById(id);
            } else {
                this.root = null;
            }
        } else {
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
    private int leftType;   //0表示左子树，1表示前驱结点
    private int rightType;  //0表示右子树，1表示后继结点


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

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

