package 剑指Offer复习;/* 2021/2/4 22:30 */
/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// [2,3,4] 的中位数是 3
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
// 设计一个支持以下两种操作的数据结构：
//
//
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。
// double findMedian() - 返回目前所有元素的中位数。
// 示例 1：
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
 */

import org.junit.Test;

import java.util.*;//

public class _41_数据流中的中位数 {//

    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());//1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());//2.0
    }
}

class MedianFinder {
    // TODO: 2021/2/4 使用两个堆结构实现，小顶堆存储大数字，大顶堆存储小数字.
    // /\ A dig num, get min to and ↓
    // \/ B small num, get max and ↑

    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>();//小顶堆 big num
        B = new PriorityQueue<>((x, y) -> (y - x));//大顶堆 small num
    }

    public void addNum(int num) {
        //已经存了偶数个元素（AB各存了一半），默认放到A中。
        if (A.size() == B.size()) {
            B.add(num);
            A.add(B.poll());//通过B获取
        } else { //否则（B少元素），放到B中。
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        return (A.size() == B.size()) ? (A.peek() + B.peek()) / 2.0 : A.peek() * 1.0;
    }
}