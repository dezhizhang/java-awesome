package shop.xiaozhi.linkedlist;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");
        HeroNode heroNode5 = new HeroNode(2,"小卢","玉麒麟~~~");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByOrder(heroNode4);
        linkedList.addByOrder(heroNode1);
        linkedList.addByOrder(heroNode3);
        linkedList.addByOrder(heroNode2);
        linkedList.addByOrder(heroNode3);
        linkedList.list();
        linkedList.update(heroNode5);
        System.out.println("------");
        linkedList.list();
        System.out.println("------");
        linkedList.del(1);
        linkedList.list();

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
