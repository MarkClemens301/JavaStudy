package 排序;/* 2020/8/21 9:22 */

import org.junit.Test;

import java.util.Arrays;

public class 原地快排_非递归栈 {
    @Test
    public void t() {
        int[] array = {20, 3, 5, 0, 32, 22, 11, 8, 7, 9};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] nums) {
        //quickSort(nums, 0, nums.length - 1);
    }
    // TODO: 2020/8/21 用栈实现的非递归快排，下回再写
}
