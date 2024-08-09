package shop.xiaozhi.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 得到最大数的位数
    public static int getMaxLeft(int max) {
        return (max + "").length();
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        int maxLength = getMaxLeft(max);

        int[][] bucket = new int[10][arr.length];
        // 创建一个一维数据存放每个数据
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {
                // 取出每个元数的个位数的值
                int digitOfElement = (arr[j] / n) % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的顺序放入原来的数组
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }


    }
}
