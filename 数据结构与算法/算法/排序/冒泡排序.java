package 算法.排序;/* 2020/10/13 0:28 */

import java.util.Arrays;

public class 冒泡排序 {//

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 9, 9, 6, 6, 4, 45, 68, 0, 1};
        new 冒泡排序().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {//冒泡
                if (arr[j] < arr[j - 1]) {//上浮一步
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }//
    }
}
