package shop.xiaozhi.movezero;
import java.util.Arrays;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。
// https://leetcode.cn/problems/move-zeroes/description/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if(nums == null) {
            return;
        }
        // 第一次遍历j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j=0;
        for(int i=0;i < nums.length;i++) {
            if(nums[i]!= 0) {
                nums[j++] = nums[i];
            }
        }

        for(int i = j;i < nums.length;i++) {
            nums[i] = 0;
        }
    }
}
