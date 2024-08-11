package shop.xiaozhi.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        int temp = 0;
        // 将元序序列构建成一个大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    // 将数组调整成大顶堆
    public static void adjustHeap(int[] arr, int i, int length) {
        // 取出当前元素的值，存在在临时变量
        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 左子节点的值小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] < temp) {
                break;
            }

            arr[i] = arr[k];
            i = k;

        }
        arr[i] = temp;
    }
}
