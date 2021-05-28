package 剑指Offer复习;/* 2020/10/23 22:27 */

import org.junit.Test;

import java.util.Arrays;

/*
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。
 */
public class _21_调整数组顺序使先奇数后偶数 {//

    @Test
    public void t() {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }

    //首尾|双指针
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int head = -1, tail = nums.length;
        while (++head < --tail) {
            while (nums[head]%2==1) head++;//向后找偶数
            while (nums[tail]%2==0) tail--;//向前找奇数
            int tmp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = tmp;
        }
        return nums;
    }
}
