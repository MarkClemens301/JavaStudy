package 算法.排序;

import org.junit.Test;

import java.util.Arrays;

public class quickSort {
    @Test
    public void t() {
        int[] nums;
        nums = new int[]{1, 2, 5, 6, 4, 8, 1, 0};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public quickSort() {
    }

    /*
    原地快排
    quickSort + partition
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        left = Math.max(0, left);
        right = Math.min(nums.length - 1, right);
        //分段排序
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left, index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) { //i 记录小值位置
                if (i != index) swap(nums, i, index);//翻转
                index++; //index 记录大值位置
            }
        }
        swap(nums, pivot, index - 1); //枢纽值换位
        return index - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}
