package shop.xiaozhi.linkedlist;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByOrder(heroNode4);
        linkedList.addByOrder(heroNode1);
        linkedList.addByOrder(heroNode3);
        linkedList.addByOrder(heroNode2);
        linkedList.list();
//        linkedList.update(heroNode5);
//        System.out.println("------");
//        linkedList.list();
//        System.out.println("------");
//        linkedList.del(1);
//        linkedList.list();

//        int length = getLength(linkedList.getHead());
//
//        System.out.println(length);

//        HeroNode lastIndexNode = findLastIndexNode(linkedList.getHead(), 1);
//        System.out.println(lastIndexNode);

        reverseList(linkedList.getHead());

        linkedList.list();



    }
    // 统计链表中有效节点的个数
    public static int getLength(HeroNode head) {
        if(head.next == null) {
            return 0;
        }
        int length = 0;
        // 定义一个临时变量
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return  length;
    }

    // 查找单链表第k个结点
    // 编写一个方法接收head节点同时接收index
    // index表示倒数第index个节点
    // 先把链表从头到尾遍历得到链表的总长度getLength
    // 得到size后从链表的第一个开始遍历(size - index)个就得到倒数第k个节点
    // 如果找到则返回该节点，否则返回null
    public static  HeroNode findLastIndexNode(HeroNode head,int index) {
        // 判断如果链表为空则返回null
        if(head.next == null) {
            return null;
        }
        // 遍历得到链表的长度
        int size = getLength(head);
        // 校检index是否超过边界
        if(index < 0 || index > size) {
            return null;
        }
        // 定义一个临时变量 循环定位到倒数的index
        HeroNode cur = head.next;

        for(int i=0;i < size - index;i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 单链表反转
//    public static void reverseList(HeroNode head) {
//        // 如果当前链表为空或只有一个节点无需反转直接返回
//        if(head.next == null || head.next.next == null) {
//            return;
//        }
//
//        // 定义一个临时变量
//        HeroNode cur = head.next;
//        HeroNode next = null;
//        HeroNode reverseHead = new HeroNode(0,"","");
//
//        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
//        while (cur != null) {
//            next = cur.next;
//            cur.next = reverseHead.next;
//            reverseHead.next = cur;
//            cur = next;
//        }
//        // 将head.next指向reverseHead.next实现单链表的反转
//        head.next = reverseHead.next;
//    }
    public static void reverseList(HeroNode head) {
        // 如果当前链表为空或只有一个节点无需反转直接返回
        if(head.next == null || head.next.next == null) {
            return;
        }

        // 定义一个临时变量
        HeroNode cur = head.next;
        HeroNode next = null;

        HeroNode reverseHead = new HeroNode(0,"","");

        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        //将head.next指向reverseHead.next实现单链表的反转
        head.next = reverseHead.next;
    }

}

class  SingleLinkedList{
    // 先初始化一个头节点
    private  HeroNode head = new HeroNode(0,"","");
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        // 遍历链表找到最后一个节点
        while (true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public HeroNode getHead() {
        return head;
    }

    // 根据HeroNode的no来修改
    public void update(HeroNode heroNode) {
        // 判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        // 表示是否找到该节点
        boolean flag = false;
        while (true) {
            if(temp == null) {
                //已经遍历完链表
                break;
            }
            if(temp.no == heroNode.no) {
                //找到要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if(flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
            return;
        }
        System.out.printf("没有找到编号为%d的节点",heroNode.no);
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no > heroNode.no) {
                break;
            }
            if(temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            System.out.printf("准备插入的英雄编号%d已经存在了，不能添加\n",heroNode.no);
            return;
        }

        // 插入到链表中
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    public void del(int no) {
        HeroNode temp = head;
        // 标识是否找到待删除节点
        boolean flag = false;
        while (true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.next = temp.next.next;
            return;
        }

        System.out.println("删除的节点不存在");
    }

    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        while (true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class  HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    // 构造器
    public  HeroNode(int no,String name,String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
