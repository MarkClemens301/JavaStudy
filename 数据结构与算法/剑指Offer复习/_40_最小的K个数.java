package 剑指Offer复习;/* 2021/2/3 23:48 */
/*

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
        Integer[] res;
        res = getLeastNumbers(new int[]{0, 1, 2, 1}, 1);
        System.out.println(Arrays.toString(res));
        res = getLeastNumbers(new int[]{0, 1, 2, 1}, 3);
        System.out.println(Arrays.toString(res));
    }

    public Integer[] getLeastNumbers(int[] arr, int k) {
        if (arr == null) return null;
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
        return res.toArray(new Integer[0]);
    }
}
