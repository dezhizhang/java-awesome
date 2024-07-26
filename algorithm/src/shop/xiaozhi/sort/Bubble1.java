package shop.xiaozhi.sort;

public class Bubble1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int temp = 0;
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果发现前面的数大于后面的则交换
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println("第" + (i + 1) + "轮");
            if(!flag) {
                break;
            }
            flag = false;
        }
    }
}
