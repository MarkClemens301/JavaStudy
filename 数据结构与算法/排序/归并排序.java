package 排序;/* 2020/8/24 0:06 */

import com.sun.scenario.effect.Merge;
import org.junit.Test;

import java.util.*; //import java.io.*;

/*
分治思想
将数组不断分二，对子集和排序，最后再合并子集合
归并O(nlogn) 速度只差于快排

初始  [49] [38] [65] [97] [76] [13] [27]
step1 [38 49] [65 97] [13 76] [27]
step2 [38 49 65 97] [13 27 76]
step3 [13 27 38 49 65 76 97]
end
 */
public class 归并排序 {
    @Test
    public void test() {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
    }

    public void mergeSort(int[] arr) {
        //System.out.println("开始排序");
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        //二路归并排序
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[arr.length]; //这里创建了临时空间 O(N)
        int r1 = mid + 1;
        int tId = left;
        int cId = left;
        //逐个归并
        while (left <= mid && r1 <= right) {
            if (arr[left] <= arr[r1]) {
                tmp[tId++] = arr[left++];
            } else {
                tmp[tId++] = arr[r1++];
        }
        //左边的归并
        while (left <= mid) {
            tmp[tId++] = arr[left++];
        }
        //右边的归并
        while (r1 <= right) {
            tmp[tId++] = arr[r1++];
        }
        //临时数组拷贝到原数组
        while (cId <= right) {
            arr[cId] = tmp[cId];
            cId++;
        }
    }
}
