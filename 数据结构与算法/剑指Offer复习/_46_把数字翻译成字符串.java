// package 剑指Offer复习;/* 2021/5/25 23:51 */
/*
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//
//
// 示例 1:
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
 */

import org.junit.Test;

import java.util.*;//

public class _46_把数字翻译成字符串 {//

    @Test
    public void t1() {
        System.out.println("'hello'");
        System.out.println(translateNum(12258));
    }

    public static void main(String[] args) {
        _46_把数字翻译成字符串 m = new _46_把数字翻译成字符串();
        m.t1();
    }

    public int translateNum(int num) {
        char[] ss = String.valueOf(num).toCharArray();
        int[] dp = new int[ss.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        //第n个数的前两个数组合位于10~25，那么dp[n]=dp[n-1]+dp[n-2] //todo 动态规划
        //TODO 未完待续   今天迁移了一百多个本地github repos 没来得及写代码...--test
        //test git tool 2021-5-27
        for (int i = 2; i <= ss.length; i++) {
            int tmp = (ss[i - 2] - '0') * 10 + (ss[i - 1] - '0');
            if (tmp > 9 && tmp < 26) dp[i] = dp[i - 1] + dp[i - 2];//可以组合 2021-6-9
            else dp[i] = dp[i - 1]; //不可以组合
        }
        return dp[dp.length - 1];///28 share
    }
}
