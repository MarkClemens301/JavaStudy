package 剑指Offer复习;/* 2020/9/8 11:49 */

import org.junit.Test;

import java.util.*;//

public class _03数组中的重复数字 {
    @Test
    public void t() {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumberF1(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    //思路：循环原地排序
    public int findRepeatNumber(int[] nums) {
        //数字在0~n-1范围内，直接用nums原地即可
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                //剪枝条件
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //swap(ni, nums[ni])
                int val = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = val;
            }
        }
        return -1;//未找到
    }

    public int findRepeatNumberF1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {//加入成功则返回true
                return num;
            }
        }
        return -1;//未找到
    }
}
