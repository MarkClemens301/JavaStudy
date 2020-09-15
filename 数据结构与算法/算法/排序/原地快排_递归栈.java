package 算法.排序;/* 2020/8/21 9:22 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class 原地快排_递归栈 {
    @Test
    public void t() {
        int[] arr = {20, 3, 5, 0, 32, 22, 11, 8, 7, 9};
        quickSortTest(arr);
        quickSortTest(new int[]{1, 25, 5, 6, 9});
        quickSortTest(new int[]{20, 3, 5, 0, 32, 22, 11, 8, 7, 9});
    }

    private void quickSortTest(int[] nums) {
        quickSort(nums);
        String s = Arrays.toString(nums);
        System.out.println(s.replaceAll("\\[|\\]|,", ""));
    }

    /**
     * 和递归的唯一不同是，
     * stack.push(left, pivot-1);
     * stack.push(pivot+1, right);
     * 需要判断边界问题！ left < pivot-1
     */
    public void quickSort(int[] nums) {
        //quickSort(nums, 0, nums.length - 1);
        int left = 0, right = nums.length - 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            int high = stack.pop(); //注意：先取出的是左边界
            int low = stack.pop();
            int pivot = partition(nums, low, high);
            if (low < pivot - 1) { //务必判断这个条件，否则溢出
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }
    // TODO: 2020/8/21 用栈实现的非递归快排，下回再写 2020-8-23 已写

    private int partition(int[] nums, int left, int right) {
        int pivot = left, index = pivot + 1;
        for (int i = index; i <= right; i++) { //注意：一定要理解
            //遇到小值，小值和大值位置互换
            if (nums[i] < nums[pivot]) {
                if (i != index) swap(nums, i, index);
                index++; //下一个大值
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int val = nums[i];
        nums[i] = nums[j];
        nums[j] = val;
    }
}
