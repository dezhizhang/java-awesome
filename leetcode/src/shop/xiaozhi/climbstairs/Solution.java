package shop.xiaozhi.climbstairs;

import java.util.HashMap;
import java.util.Map;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

//https://leetcode.cn/problems/climbing-stairs/description/
public class Solution {
    private static final Map<Integer, Integer> storeMap = new HashMap<>();

    public static void main(String[] args) {
        int res = climbStairs(12);
        System.out.println(res);

    }

    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(null != storeMap.get(n)) {
            return storeMap.get(n);
        }else {
            int result = climbStairs(n - 1) + climbStairs(n -2);
            storeMap.put(n,result);
            return result;
        }
    }

    public static int climbStairs1(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int result = 0;
        int pre = 2;
        int prePre = 1;

        for(int i=3;i <=n;i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return  result;
    }
}
