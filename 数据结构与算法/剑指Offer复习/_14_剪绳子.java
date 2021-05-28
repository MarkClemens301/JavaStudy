package 剑指Offer复习;/* 2020/9/13 14:12 */

import org.junit.Test;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//
// 示例 2:
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//
//
//
// 提示：
//
//
// 2 <= n <= 1000
//
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
// Related Topics 数学 动态规划
// 👍 22 👎 0
public class _14_剪绳子 {//

    @Test
    public void t() {
        System.out.println("cuttingRope(2) = " + cuttingRope(2));
        System.out.println("cuttingRope(10) = " + cuttingRope(10));
        System.out.println("cuttingRope(123456789) = " + cuttingRope(123456789));
    }

    public int cuttingRope(int n) {
        if (n == 2) return 1;//1*1
        if (n == 3) return 2;//1*2
        long res = 1L;
        int p = 1000000007;
        //大数 循环取余
        while (n > 3) {//凑三
            res = res * 3 % p;
            n -= 3;//4-1 5-2 6-3
        }
        if (n == 1) return (int) (res / 3 * 4 % p);
        else return (int) (res * n % p);
    }

    //上面是循环求余，还有一种快速幂 方法
    private long fastMod(int x, int n, int p) {//x^n % p
        long res = 1L;
        //p=1000000007;
        while (n > 0) {
            /* x^11 = x^1 * {(x^2)^5}
            = x^1 * (x^2)^1 * {(x^2)^2)^2}
            = x^1 * (x^2)^1 * {[((x^2)^2)^2]^1}
            = x^1 * (x^2)^1 * [((x^2)^2)^2]^1 * {[((x^2)^2)^2]^1}^0
             */
            if (n % 2 != 0) res = res * x % p;//留一个 or 直到只剩下一个大元素
            x = x * x % p;//元素大小
            n /= 2;//元素个数
        }
        return res;
    }

    @Test
    public void t2() {
        System.out.println(fastMod(2, 10, 1000000007));
        System.out.println(fastMod(2, 11, 1000000007));
        System.out.println(fastMod(3, 30, 1000000007));
        System.out.println(fastMod_(3, 30, 1000000007));
    }

    long fastMod_(int x, int n, int p) {
        long res = 1;//1L;
        while (n > 0) {
            if ((n & 1) == 1) res = res * x % p;
            x = x * x % p;
            n >>= 1;
        }
        return res;
    }
}