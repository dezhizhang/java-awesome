package shop.xiaozhi.sort;

import java.util.Arrays;

// 选择排序
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr) {
        for(int i=0;i < arr.length - 1;i++) {
            // 最小值
            int min = arr[0];
            // 最小索引
            int minIndex = i;
            for(int j = 1 + i;j < arr.length;j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
