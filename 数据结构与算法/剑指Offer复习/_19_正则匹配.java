package 剑指Offer复习;/* 2020/9/13 23:16 */

import org.junit.Test;

public class _19_正则匹配 {//难题

    @Test
    public void t() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println("isMatch(" + s + ", " + p + ") = " + isMatch(s, p));//false
    }

    //DP 动态规划
    boolean isMatch(String A, String B) {
        int m = A.length(), n = B.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = (i == 0);
                } else {//非空正则串
                    if (B.charAt(j - 1) == '*') {//包含*
                        if (j >= 2) {//不用*
                            dp[i][j] |= dp[i][j - 2];
                        }
                        boolean flag = i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.');
                        if (flag) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                    if (B.charAt(j - 1) != '*') {//不包含*
                        if (i >= 1 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

}
