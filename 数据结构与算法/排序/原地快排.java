package 排序;/* 2020/8/21 9:02 */

import org.junit.Test;

import java.util.Arrays;

public class 原地快排 {
    @Test
    public void t() {
        int[] array = {20, 3, 5, 0, 32, 22, 11, 8, 7, 9};
        //quickSort(array);
        sortTest(array);
    }

    public void sortTest(int[] array) {
        System.out.println("Before: " + Arrays.toString(array));
        quickSort(array);
        System.out.println("After: " + Arrays.toString(array));
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        boolean needPrint = true; //todo 打印每次pivot结果
        //if (left >= right) return;
        left = Math.max(left, 0);
        right = Math.min(right, nums.length - 1);
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            if (needPrint)
                System.out.println(left + " " + "; " + partitionIndex + "; " + " " + right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left, index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) { // index 默认为大值的索引
                if (i != index) swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
