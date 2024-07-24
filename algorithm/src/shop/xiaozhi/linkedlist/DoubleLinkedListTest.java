package shop.xiaozhi.linkedlist;



class  DoubleLinkedListTest{
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4,"林冲","豹子头");

        HeroNode2 heroNode5 = new HeroNode2(4,"公孙胜","入云龙");

        //创建双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);


        doubleLinkedList.list();
        doubleLinkedList.update(heroNode5);
        doubleLinkedList.list();

        doubleLinkedList.del(3);
        doubleLinkedList.list();






    }
}

class DoubleLinkedList {
    // 先初始化一个头节点
    private  HeroNode2 head = new HeroNode2(0,"","");
    public void list() {
        // 判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 创建一个临时变量保存头节点
        HeroNode2 temp = head.next;
        while (true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 对于双向链表，直接找到删除这个节点
    // 找到后自我删除即可
    public void del(int no) {
        // 判断当前链表是否为空
        if(head.next == null) {
            System.out.println("链表为空无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            // 已经到链表的最后
            if(temp == null) {
                break;
            }

            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.pre.next = temp.next;
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
            return;
        }
        System.out.println("删除的节点不存在");
    }
    // 修改节点内容
    public void update(HeroNode2 heroNode) {
        // 判断是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 找到需要修改的节点
        HeroNode2 temp = head.next;
        // 表示是否找到该节点
        boolean flag = false;
        while (true) {
            if(temp == null) {
                break;
            }

            if(temp.no == heroNode.no) {
                // 找到要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
            return;
        }
        System.out.printf("没有找到编号%d的节点",heroNode.no);
    }
    // 双向链表添加最后
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if(temp.next == null) {
                break;
            }
            // 如果没有找到最后，移动temp
            temp = temp.next;
        }

        temp.next = heroNode;
        heroNode.pre = temp;
    }
}


class  HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre; // 指向前一个节点
    // 构造器
    public  HeroNode2(int no,String name,String nickname) {
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
