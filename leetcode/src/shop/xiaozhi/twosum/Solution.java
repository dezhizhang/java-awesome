package shop.xiaozhi.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.cn/problems/two-sum/
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] index = twoSum1(nums, 9);
        System.out.println(Arrays.toString(index));
    }

    public  static int[] twoSum(int[] nums,int target) {
        int[] result = new int[2];
        for(int i=0;i <nums.length;i++) {
            for(int j=i+1;j < nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static  int[] twoSum1(int[] nums,int target) {
        Map<Integer,Integer> storeNums = new HashMap<>(nums.length);

        int[] result = new int[2];

        for(int i=0;i < nums.length;i++) {
            int another = target - nums[i];

            Integer index = storeNums.get(another);
            if(null != index) {
                result[0] = index;
                result[1] = i;
                return  result;
            }else {
                storeNums.put(nums[i],i);
            }
        }
        return result;
    }

}
