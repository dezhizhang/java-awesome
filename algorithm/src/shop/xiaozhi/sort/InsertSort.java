package shop.xiaozhi.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insetSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void insetSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 待插入值
            int insetValue = arr[i];
            // 待插入索引
            int insetIndex = i - 1;
            //1. insetIndex>0保证在给insetValue 找位置不越界
            //2. insetValue < arr[insetIndex]待插入的数，还没有找到插入位置
            //3. 需要将arr[insetIndex]后移

            while (insetIndex >= 0 && insetValue < arr[insetIndex]) {
                arr[insetIndex + 1] = arr[insetIndex];
                insetIndex--;
            }

            arr[insetIndex + 1] = insetValue;

        }
    }
}
