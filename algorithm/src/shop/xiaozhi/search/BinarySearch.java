package shop.xiaozhi.search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 89, 1000, 1234};
        ArrayList<Integer> integers = binarySearch1(arr, 0, arr.length - 1, 89);

        System.out.println(integers);
    }

    public static int binarySearch(int[] arr, int left, int right, int findValue) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (left > right) {
            return -1;
        }

        if (findValue > midValue) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }

    }

    public static ArrayList<Integer> binarySearch1(int[] arr, int left, int right, int findValue) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (left > right) {
            return new ArrayList<>();
        }
        if (findValue > midValue) {
            return binarySearch1(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return binarySearch1(arr, left, mid - 1, findValue);
        } else {
            ArrayList<Integer> resultIndex = new ArrayList<>();
            // 向左查找
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                resultIndex.add(temp);
                temp -= 1;
            }
            resultIndex.add(temp);
            // 向左查找
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {
                    break;
                }
                resultIndex.add(temp);
                temp += 1;
            }
            return resultIndex;
        }
    }
}
