package 剑指Offer复习;/* 2021/2/3 23:48 */
/*输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
 */

import org.junit.Test;

import java.util.*;//

public class _40_最小的K个数 {//

    @Test
    public void test() {
        int[] res;
        res = getLeastNumbers_(new int[]{0, 1, 2, 1}, 1);
        System.out.println(Arrays.toString(res));
        res = getLeastNumbers_(new int[]{0, 1, 2, 1}, 3);
        System.out.println(Arrays.toString(res));
        res = getLeastNumbers(new int[]{0, 1, 2, 1}, 1);
        System.out.println(Arrays.toString(res));
        res = getLeastNumbers(new int[]{0, 1, 2, 1}, 3);
        System.out.println(Arrays.toString(res));
    }
    /*
    todo
    F1 工具类排序，取左侧
    F2 优先队列排序（小顶堆），取堆顶
    F3 大小为K的大顶堆；需要溢出时，溢出堆顶元素，保证小值还在堆里
     */

    //优先队列排序
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k == 0) return new int[0];
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!heap.isEmpty()) {
                res.add(heap.poll());
            }
        }
        int[] res_ = new int[k];
        for (int i = 0; i < res.size(); i++) {
            res_[i] = res.get(i);
        }
        return res_;
    }

    //K大顶堆
    public int[] getLeastNumbers_(int[] arr, int k) {
        if (arr == null || k == 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>(k,
                (i1, i2) -> Integer.compare(i2, i1));//修改为数量为K的大顶堆
        for (int e : arr) {
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) heap.offer(e);
            if (heap.size() > k) heap.poll();
        }
        int[] res = new int[k];
        int i = 0;
        for (Integer e : heap) {
            res[i++] = e;
        }
        return res;
    }
}
