package shop.xiaozhi.binary;

public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9 };

        BinarySortTree binarySortTree = new BinarySortTree();

        for (int j : arr) {
            binarySortTree.add(new Node(j));
        }

        binarySortTree.infixOrder();

        // 测试删除叶子节点
        binarySortTree.delNode(5);
    }
}

// 创建二叉排序树
class BinarySortTree {
    private Node root;

    // 查找父节点
    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    // 查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    // 删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        }

        Node targetNode = search(value);

        // 如果没有找到要删除的节点
        if (targetNode == null) {
            return;
        }

        // 当前这颗二叉树只有一个节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        // 找到targetNode的父节点
        Node parent = searchParent(value);
        // 如果要删除的节点是叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            // 判断targetNode是父节点的左子节点，还是右子节点
            if (parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent.right != null && parent.right.value == value) {
                // 是右子节点
                parent.right = null;
            }
        }

    }


    // 添加节点
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

    // 查找要删除的节点
    public Node search(int value) {
        if (value == this.value) {
            // 找到该节点
            return this;
        }

        if (value < this.value) {
            // 查找的值小于当前节点的值向左子树递归查找
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            // 查找的值大于当前节点值向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    // 查找要删除节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果查找的值小于当前节点的值，并且当前节点的值左子节点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                // 右子树递归查找
                return this.right.searchParent(value);
            } else {
                // 设有父节点
                return null;
            }
        }
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


