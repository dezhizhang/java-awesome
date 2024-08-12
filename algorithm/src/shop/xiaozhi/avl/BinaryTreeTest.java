package shop.xiaozhi.avl;

public class BinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();

        for (int j : arr) {
            avlTree.add(new Node(j));
        }
        avlTree.infixOrder();
        System.out.println(avlTree.height());
//        System.out.println(avlTree);

    }
}

class AVLTree {
    private Node root;

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

    public int height() {
        if (root == null) {
            System.out.println("树为空");
            return 0;
        }
        return root.height();
    }

}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    // 返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // 返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    // 添加节点
    public void add(Node node) {
        if (node == null) {
            return;
        }
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

        // 当添加完一个节点后，如果:(右子树的高度-左子树高度) > 1 左旋转
        if (rightHeight() - leftHeight() > 1) {
            leftRotate();
        }
    }

    // 返回当前节点的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
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

    // 右旋转二叉树
    public void leftRotate() {
        // 创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        // 把新的节点的右子树设置成右子树的左子树
        newNode.right = right.left;
        // 把当前节点的值替换成右子节点的值
        value = right.value;
        // 把当节节点的右子树设置成当前右子树的右子树
        right = right.right;
        // 把当前节点的左子树设置成新结点
        left = newNode;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }
}
