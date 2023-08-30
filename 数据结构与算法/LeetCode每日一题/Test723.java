package LeetCode每日一题;


import org.junit.Assert;
import org.junit.Test;

/**
 * 动态规划
 */
public class Test723 {
    /**
     * 强盗抢劫
     * f[n] = max{
     * f[n-1],  前一个已发生抢劫
     * f[n-2] + nums[n]  前一个未发生，当前户可抢劫
     * }
     *
     * @param nums {@code null}
     * @return R
     */
    public int robs01(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int pre2 = 0, pre1 = 0, tmp;
        for (int i = 0; i < nums.length; i++) {
            tmp = pre1;
            pre1 = Math.max(pre2 + nums[i], pre1);
            pre2 = tmp;
        }
        return pre1;
    }

    @Test
    public void test02() {
        Assert.assertEquals(0, robs01(null));
        Assert.assertEquals(1, robs01(new int[]{1}));
        Assert.assertEquals(2, robs01(new int[]{1, 2}));
        Assert.assertEquals(44, robs01(new int[]{1, 33, 4, 9, 0, 2}));
    }

    /**
     * 斐波那契
     * 0:1 1:1 2:2 3:3
     * f[n] = f[n-2] + f[n-1]
     *
     * @param n order
     * @return int
     */
    public int febnaci(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2, tmp;
        for (int i = 3; i <= n; i++) {
            tmp = pre2;
            pre2 = pre1 + pre2;
            pre1 = tmp;
        }
        return pre2;
    }

    @Test
    public void test01() {
        System.out.println("febnaci(33) = " + febnaci(33));
        Assert.assertEquals(1, febnaci(1));
        Assert.assertEquals(2, febnaci(2));
        Assert.assertEquals(3, febnaci(3));
        Assert.assertEquals(5, febnaci(4));
        Assert.assertEquals(8, febnaci(5));
        System.out.println("febnaci(5) = " + febnaci(5));
    }
}
