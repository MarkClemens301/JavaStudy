package 算法.动态规划;/* 2020/10/9 23:51 */

import org.junit.Test;

public class 数组区间和 {//

    public static void main(String[] args) {

    }

    @Test
    public void t() {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        System.out.println("sumRange(nums, i, j) = " + sumRange(nums, 0, 2));
        System.out.println("sumRange(nums, i, j) = " + sumRange(nums, 2, 5));
        System.out.println("sumRange(nums, i, j) = " + sumRange(nums, 0, 5));
        //1 -1 -3
    }

    public int sumRange(int[] nums, int l, int r) {
        int n = nums.length;
        int[] dp = new int[n + 1];//dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
        return dp[r + 1] - dp[l];
    }
}
/*
1. 数组区间和
303. Range Sum Query - Immutable (Easy)

Leetcode / 力扣

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
求区间 i ~ j 的和，可以转换为 sum[j + 1] - sum[i]，其中 sum[i] 为 0 ~ i - 1 的和。
 */