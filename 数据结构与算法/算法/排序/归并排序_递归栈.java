/* 2020/9/4 14:33 */
package 算法.排序;/* 2020/9/4 14:33 */

import java.util.*; //import java.io.*;

public class 归并排序_递归栈 {
    public static void main(String[] args) {
        归并排序_递归栈 main = new 归并排序_递归栈();
        main.test();
    }

    private int n;
    private int[] arr;

    public void test() {
        getScanner();
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr, int left, int right) {//无序数组分解归并，非递归（广度用队列，深度用栈）
        if (left >= right) return;
        /* 递归版本 */
        //int mid = (left + right) >> 1;//中点
        //mergeSort(arr, left, mid);
        //mergeSort(arr, mid + 1, right);
        //merge(arr, left, mid, right);
        /* 非递归版本 */
        Queue<int[]> queue4M = new LinkedList<>();//
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{left, right});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            left = pair[0];
            right = pair[1];
            int mid = (left + right) >> 1;
            if (left < right) {//继续入栈 [1 2 3]分割 [1 2]不分割
                queue.offer(new int[]{left, mid});
                queue.offer(new int[]{mid + 1, right});
                queue4M.offer(new int[]{left, mid, right});//
            }
        }
        while (!queue4M.isEmpty()) {
            int[] pair = queue4M.poll();
            merge(arr, pair[0], pair[1], pair[2]);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {//通用有序数组合并
        //(left, mid) (mid+1, right)
        if (right == left) return;//一个数
        int n = right - left + 1;//合并段的段程
        int[] temp = new int[n];
        int idl = left, idr = mid + 1, idt = 0;
        while (idl <= mid && idr <= right) {
            if (arr[idl] <= arr[idr]) {
                temp[idt++] = arr[idl++];
            } else {
                temp[idt++] = arr[idr++];
            }
        }
        while (idl <= mid) {
            temp[idt++] = arr[idl++];
        }
        while (idr <= right) {
            temp[idt++] = arr[idr++];
        }
        for (int i = 0; i < n; i++) {
            arr[left + i] = temp[i];
        }
    }

    /*
    12
    1 5 9 8 6 2  5 5 6 9 10 3
     */
    private void getScanner() {
        Scanner sc = new Scanner(System.in);
        //输入一组无序数据，进行归并排序后，输出
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
}

class Sort {
    public static void main(String[] args) {
        Sort main = new Sort();
        //测试
        int[] array = {12, 1, 5, 9, 8, 6, 2, 5, 5, 6, 9, 10, 3};
        System.out.println("Before Sort: " + Arrays.toString(array));
        main.mergeSort(array);
        System.out.println("After Sort: " + Arrays.toString(array));

    }

    private void mergeSort(int[] arr) {
        mergeSortLoop(arr, 0, arr.length - 1);
    }

    /* 递归版本 */
    private void mergeSortRecur(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;//中点
        mergeSortRecur(arr, left, mid);
        mergeSortRecur(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /* 非递归版本 */
    private void mergeSortLoop(int[] arr, int left, int right) {
        if (left >= right) return;
        LinkedList<int[]> queue4M = new LinkedList<>();//用于记录数组合并的节点位置
        Queue<int[]> queue = new LinkedList<>();//用于子问题分解
        queue.offer(new int[]{left, right});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            left = pair[0];
            right = pair[1];
            int mid = (left + right) >> 1;
            if (left < right) {//继续入栈 [1 2]分割 [1]不分割
                queue.offer(new int[]{left, mid});
                queue.offer(new int[]{mid + 1, right});
                queue4M.add(new int[]{left, mid, right});//
            }
        }
        while (!queue4M.isEmpty()) {
            int[] pair = queue4M.removeLast();//重要，必须从队列尾部开始归并
            merge(arr, pair[0], pair[1], pair[2]);
        }
    }

    /*通用有序数组合并, 递归、非递归都要用到*/
    private void merge(int[] arr, int left, int mid, int right) {
        //(left, mid) (mid+1, right)
        if (right == left) return;//一个数
        int n = right - left + 1;//合并段的段程
        int[] temp = new int[n];
        int idl = left, idr = mid + 1, idt = 0;
        while (idl <= mid && idr <= right) {
            if (arr[idl] <= arr[idr]) {
                temp[idt++] = arr[idl++];
            } else {
                temp[idt++] = arr[idr++];
            }
        }
        while (idl <= mid) {
            temp[idt++] = arr[idl++];
        }
        while (idr <= right) {
            temp[idt++] = arr[idr++];
        }
        for (int i = 0; i < n; i++) {
            arr[left + i] = temp[i];
        }
        System.out.println(Arrays.toString(temp));//排序和归并过程！
    }
}