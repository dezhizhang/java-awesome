package shop.xiaozhi.tree;

public class ThreadedTreeTest {
    public static void main(String[] args) {

    }
}

class BinaryTree2 {
    private HeroNode2 root;

    public void setRoot(HeroNode2 root) {
        this.root = root;
    }

    // 线索化二叉树
    public void threadedNode(HeroNode2 node) {
        // 不能线索化
        if (node == null) {
            return;
        }

    }

}

class HeroNode2 {
    public int no;
    public String name;
    public HeroNode2 left;
    public HeroNode2 right;
    // 如果leftType=0表示指向是左子树,如果1则表示指向前驱节点
    public int leftType;
    // 如果rightType=0表示指向右子树,如果1表示指向后继节点
    public int rightType;

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" + "no=" + no + ", name='" + name + '\'' + '}';
    }
}
