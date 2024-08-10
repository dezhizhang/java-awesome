package shop.xiaozhi.hash;

import java.util.Scanner;

public class HashTableTest {
    public static void main(String[] args) {
        // 创建哈希表
        HashTab hashTab = new HashTab(7);

        // 写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    // 创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    int id1 = scanner.nextInt();
                    hashTab.findEmpById(id1);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }
    }
}

// 创建hashTab 管理多条链表
class HashTab {
    public int size;
    private final EmpLinkedList[] empLinkedList;

    // 构造器
    public HashTab(int size) {
        this.size = size;
        // 初妈化
        empLinkedList = new EmpLinkedList[size];
        // 初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp) {
        int empLinkedListNo = hashFun(emp.id);
        empLinkedList[empLinkedListNo].add(emp);
    }

    // 创建散列函数使用取模法
    public int hashFun(int id) {
        return id % size;
    }

    // 遍历所有链表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedList[i].list(i);
        }
    }

    // 根据输入id查找雇员
    public void findEmpById(int id) {
        // 使用散列函数
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedList[empLinkedListNo].findEmpById(id);
        if (emp == null) {
            System.out.println("在哈希表中没有找到散列表");
            return;
        }

        System.out.printf("第%d条链表中找到雇员id = %d\n", empLinkedListNo + 1, id);
    }

}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    // 头指针，指向第一个emp
    private Emp head;

    // 添加雇员添加到链表
    public void add(Emp emp) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }

        Emp temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 加入链表
        temp.next = emp;

    }

    // 显示链表信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "链表为空");
            return;
        }
        System.out.println("第" + no + "链表信息");
        Emp temp = head;

        while (true) {
            System.out.printf("=>id=%d name=%s\t", temp.id, temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

    // 根据id查找雇员
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        Emp temp = head;
        while (true) {
            if (temp.id == id) {
                break;
            }
            if (temp.next == null) {
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
}



