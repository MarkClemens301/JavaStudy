package 剑指Offer复习;/* 2021/2/4 22:55 */
/*
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
// 要求时间复杂度为O(n)。
//
// 示例1:
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

import org.junit.Test;

import java.util.*;//

public class _42_连续子数组的最大和 {//
    @Test
    public void test1(){
        System.out.println("RUN");
        System.out.println(maxSubArray(new int[]{-2, -1}));
    }

    //动态规划
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return -1;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            //TODO
            boolean flag = dp.get(i - 1) <= 0;
            dp.add(nums[i] + (flag ? 0 : dp.get(i - 1)));
        }
        return Collections.max(dp);
    }

}
