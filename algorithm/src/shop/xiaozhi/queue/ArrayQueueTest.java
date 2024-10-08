package shop.xiaozhi.queue;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("h(head):取出队头数据");
            System.out.println("g(get): 从队列取出数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's': 
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",result);
                    }catch (Exception e) {
                       System.out.println(e.getMessage());
                    }
                    break;
                    case 'h':
                    try{
                        int result = arrayQueue.headQueue();
                        System.out.printf("取出队头数据%d\n",result);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case 'e':
                        scanner.close();
                        loop = false;
                default:
                    break;

            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue{
    private final int maxSize;
    private int front;
    private int rear;
    private final int[] array;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.array = new int[maxSize];
    }
    // 判断队列是否满
    public boolean isFull(){
      return rear == maxSize - 1;
    }
    // 判断隐表是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int value) {
        if(isFull()) {
            System.out.println("队列满不能加入数据");
            return;
        }
        this.rear++;
        this.array[rear] = value;
    }

    public int getQueue() {
        if(isEmpty()) {
            throw  new RuntimeException("队列为空不能取数据");
        }
        front++;
        return array[front];
    }
    // 显示队列所有数据
    public  void showQueue() {
        if(isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for(int i =0;i < array.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,array[i]);
        }
    }
    // 显示队列的头数据,注意不是取数据
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空不能取数据");
        }
        return array[front + 1];
    }

}



