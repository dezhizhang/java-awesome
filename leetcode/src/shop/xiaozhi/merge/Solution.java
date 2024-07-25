package shop.xiaozhi.merge;

import java.util.Arrays;


//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
// https://leetcode.cn/problems/merge-sorted-array/description/
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge1(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] temp = new int[k];

        for (int index = 0, nums1Index = 0, nums2Index = 0; index < k; index++) {
            if (nums1Index >= m) {
                // mums1数组已经取完完全取nums2数组的值即可
                temp[index] = nums2[nums2Index++];
            } else if (nums2Index >= n) {
                // mums2数组已经取完，完全取nums1数组的值即可
                temp[index] = nums1[nums1Index++];
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                // nums1数组的元素小于num2数组,取nums1数据的值
                temp[index] = nums1[nums1Index++];
            } else {
                temp[index] = nums2[nums2Index++];
            }
        }

        for (int i = 0; i < k; i++) {
            nums1[i] = temp[i];
        }
    }

    public static void merge1(int[] nums1,int m,int[] nums2,int n) {
        int k = m + n;
        for(int index = k - 1,nums1Index = m - 1,nums2Index = n - 1;index >=0;index--) {
            if(nums1Index<0) {
                //nums1已经取完，完全取nums2的值即可
                nums1[index] = nums2[nums2Index--];
            }else if(nums2Index <0) {
                // nums已取完，完全取nums1的值即可
                break;
            }else if(nums1[nums1Index] > nums2[nums2Index]) {
                // nums1的元素大于nums2取nums1值
                nums1[index] = nums1[nums1Index--];
            }else {
                // nums2的元素值大于等于nums1取nums的值
                nums1[index] = nums2[nums2Index--];
            }
        }
    }
}
