package shop.xiaozhi.dynamic;

import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        int[] w = {1, 4, 3}; // 物品的重量
        int[] val = {1500, 3000, 2000}; // 物品的价质
        int m = 4; // 背包的容量
        int n = val.length; // 物品的个数


        // 创建二维数组
        int[][] v = new int[n + 1][m + 1];
        // 为了记录放入商品的情况，定义一个二维数组
        int[][] path = new int[n + 1][m + 1];

        // 初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        Arrays.fill(v[0], 0);

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                // 公式
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        // 输出放入的那些商品
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("装入的商品最大值%d", v[i][j]);
                j -= w[i - 1];
                break;
            }
            i--;

        }
    }
}


