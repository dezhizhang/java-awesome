package shop.xiaozhi.sort;

import java.util.Arrays;

public class Bubble {


    public static void main(String[] args) {
        int arr[] = {20,3,9,-1,10};

        int temp = 0;

        for(int i=0;i < arr.length - 1;i++) {
            for(int j=0;j < arr.length - 1 - i;j++) {
                // 如果前面的数大于后面的数则交换
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
