package 算法.动态规划;/* 2020/10/10 0:16 */

import org.junit.Test;

import java.util.Arrays;

public class 数组的等差递增子区间 {//
    @Test
    public void t() {
        int[] arr;
        arr = new int[]{1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(arr));
        arr = new int[]{0, 1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(arr));
        //3 6
    }

    public int numberOfArithmeticSlices(int[] nums) {
        //todo When等差：dp[n]=dp[n-1]+1 会新增一个短序列。
        if (nums==null || nums.length < 3) return 0;//等差则至少要三个数
        int n = nums.length;
        int[] dp = new int[n];//dp[0]=0; dp[1]=0; //maybe dp[2]=0 +1;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).sum();//dp数组求和 不同长度的可能性
    }
    /*
    dp[2] = 1
    [0, 1, 2]
    dp[3] = dp[2] + 1 = 2
    [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
    [1, 2, 3]     // 新的递增子区间（+1） todo +1发生在这
     */
}
/*
413. Arithmetic Slices (Medium)

Node / 力扣

A = [0, 1, 2, 3, 4]

return: 6, for 3 arithmetic slices in A:

[0, 1, 2],
[1, 2, 3],
[0, 1, 2, 3],
[0, 1, 2, 3, 4],
[ 1, 2, 3, 4],
[2, 3, 4]
dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数。

当 A[i] - A[i-1] == A[i-1] - A[i-2]，那么 [A[i-2], A[i-1], A[i]] 构成一个等差递增子区间。而且在以 A[i-1] 为结尾的递增子区间的后面再加上一个 A[i]，一样可以构成新的递增子区间。

dp[2] = 1
    [0, 1, 2]
dp[3] = dp[2] + 1 = 2
    [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
    [1, 2, 3]     // 新的递增子区间
dp[4] = dp[3] + 1 = 3
    [0, 1, 2, 3, 4], // [0, 1, 2, 3] 之后加一个 4
    [1, 2, 3, 4],    // [1, 2, 3] 之后加一个 4
    [2, 3, 4]        // 新的递增子区间
综上，在 A[i] - A[i-1] == A[i-1] - A[i-2] 时，dp[i] = dp[i-1] + 1。

因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果。
 */