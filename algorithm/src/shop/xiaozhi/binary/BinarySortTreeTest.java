package shop.xiaozhi.binary;

public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};

        BinarySortTree binarySortTree = new BinarySortTree();

        for (int j : arr) {
            binarySortTree.add(new Node(j));
        }

        binarySortTree.infixOrder();
    }
}

// 创建二叉排序树
class BinarySortTree {
    private Node root;

    public void add(Node node) {

        if (root != null) {
            root.add(node);
            return;
        }
        root = node;
    }

    // 中序遍历
    public void infixOrder() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        root.infixOrder();
    }
}


class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    // 添加节点
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判断当前传入的值和当前树节点的值关系
        if (node.value < this.value) {
            // 当前节点不为空递归添加
            if (this.left != null) {
                this.left.add(node);
                return;
            }
            this.left = node;
        } else {
            // 右子树不为空递归添加
            if (this.right != null) {
                this.right.add(node);
                return;
            }
            this.right = node;
        }
    }



    // 中序遍历二叉树
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
        return "Node{" + "value=" + value + '}';
    }
}


