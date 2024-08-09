package shop.xiaozhi.search;

import java.util.Arrays;

public class DifferenceSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int index = differenceSearch(arr, 0, arr.length - 1, 10);

        System.out.println(index);
    }

    public static int differenceSearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        // 求mid
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);

        int midValue = arr[mid];

        if (findValue > midValue) {
            return differenceSearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return differenceSearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
