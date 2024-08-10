package shop.xiaozhi.hash;

public class HashTableTest {
    public static void main(String[] args) {

    }
}

// 创建hashTab 管理多条链表
class HashTab {
    public int size;
    private final EmpLinkedList[] empLinkedList;

    // 构造器
    public HashTab(int size) {
        this.size = size;
        empLinkedList = new EmpLinkedList[size];
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
            empLinkedList[i].list();
        }
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
    public void list() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        System.out.println("当前链表信息");
        Emp temp = head;

        while (true) {
            System.out.printf("=>id=%d name=%s\t", temp.id, temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

    }
}



