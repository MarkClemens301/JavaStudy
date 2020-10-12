package 算法.动态规划;/* 2020/10/11 23:08 */

import org.junit.Test;

public class 最长公共子序列 {//

    @Test
    public void t() {
        System.out.println(longestCommonSubsequence("abcde", "ace"));//3
        System.out.println(longestCommonSubsequence("abc", "def"));//0
    }

    /*
    输入：text1 = "abcde", text2 = "ace"
    输出：3
    解释：最长公共子序列是 "ace"，它的长度为 3。
    示例 2:
     */
    public int longestCommonSubsequence(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                //s1=s2
                if (a.charAt(i - 1) == b.charAt(j - 1)) {//s1 s2 正好匹配上
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {//s1匹配不上或s2匹配不上
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
