package shop.xiaozhi.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HuffmanTree {
    // static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();

    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);
        preOrder(huffmanTree);

        getCodes(huffmanTree,"",stringBuffer);


    }

    public static void preOrder(Node root) {
        if (root == null) {
            System.out.println("树为空不能遍历");
            return;
        }

        root.preOrder();
    }

    public static void getCodes(Node node, String code, StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer);

        stringBuffer2.append(code);

        if (node != null) {
            // 判断当前node是叶子结点还是非叶子节点
//            if (node.data == null) {
//                getCodes(node.left, "0", stringBuffer2);
//                getCodes(node.right, "1", stringBuffer2);
//            } else {
//                huffmanCodes.put(node.data, stringBuffer2.toString());
//            }
        }
    }


    // 创建赫夫曼树
    public static Node createHuffmanTree(int[] arr) {
        // 1遍历array数组
        // 2将array每个元素构成一个node
        // 3将node放入到arrayList
        List<Node> nodes = new ArrayList<Node>();

        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            // 从小到大排序
            Collections.sort(nodes);
            // 取出权值最小的节点(二叉树)
            Node leftNode = nodes.get(0);
            // 取出权限第二小的节点
            Node rightNode = nodes.get(1);

            // 根据节点生成一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            // 从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);

        }
        return nodes.get(0);
    }


}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;


    public Node(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }
}
