package shop.xiaozhi.linkedlist;

public class SingleCircleLinkedListTest {
    public static void main(String[] args) {
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.addBoy(5);
        singleCircleLinkedList.showBoy();
        singleCircleLinkedList.countBoy(1,2,5);
    }
}

// 创建一个环形链表
class SingleCircleLinkedList {
    // 创建一个first节点当前没有编号
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("n的值不能小于1");
            return;
        }

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);

            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    // 遍历当前
    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        // 因为first不能动，因些使用一个临时变量
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    // 根据用户的输入，计算出小孩出圈的顺序
    public void countBoy(int startNo,int countNum, int nums) {
        // 创建一个辅助指针(变量) helper事先应该指向环形链表的最后节点
        // 小孩报数前先让first和helper移动k-1次
        // 当报数时让first和helper指针移动m-1次
        // 这时就可以将first指向小孩出圈节点
        // first=first.next
        // helper.next = first

        // 先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        //让helper移动到最后一个节点
        Boy helper = first;
        while (true) {
            if(helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前先让first和helper移动k - 1次
        for(int j=0;j < startNo - 1;j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            // 说明圈中只有一个节点
            if(helper == first) {
                break;
            }

            for(int j=0; j < countNum - 1;j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            // 这里first指向的节点就是要出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            // 这里将first指向小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("取后留在圈中的小孩%d\n",first.getNo());
    }
}

class Boy {
    private int no; // 编号
    private Boy next; // 指向下一个节点默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}