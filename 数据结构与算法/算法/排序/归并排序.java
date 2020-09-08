package 算法.排序;/* 2020/8/24 0:06 */

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
    public void tests() {
        int[] arr = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        //26, 5, 98, 108, 28,| 99, 100, 56, 34, 1
        //26, 5, 98,| 108, 28,| 99, 100, 56,| 34, 1
        sortTest(arr);
        //int[] arr1 = {10, 5, 6, 9, 8, 8, 53, 5, 6, 4478, 55, 55, 66, 6, 88, 8, 668, 8, 589, 9, 95, 4};
        //sortTest(arr1);
    }

    private void sortTest(int[] arr) {
        System.out.println("Before: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    public void mergeSort(int[] arr) {
        //System.out.println("开始排序");
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2; //mid划归左区间
        //二路归并排序
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    //归并的时候进行排序，merge与快排的partition类似
    private void merge(int[] arr, int left, int mid, int right) {
        boolean needPrint = true; //todo 打印每次归并结果
        int len = right - left + 1;
        int[] tmp = new int[len]; //arr.length 这里创建了临时空间 O(N); 优化
        int tmpId = 0;
        //二路
        int l1 = left;
        int r1 = mid + 1;
        //逐个归并
        while (l1 <= mid && r1 <= right) {
            if (arr[l1] <= arr[r1]) {
                tmp[tmpId++] = arr[l1++];
            } else {
                tmp[tmpId++] = arr[r1++];
            }
        }
        //剩余的继续归并（左边或右边）
        while (l1 <= mid) tmp[tmpId++] = arr[l1++];
        while (r1 <= right) tmp[tmpId++] = arr[r1++];
        //临时数组拷贝到原数组
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i - left];
            if (needPrint) System.out.print(arr[i] + " "); //ts
        }
        if (needPrint) System.out.println(); //ts
    }
}
