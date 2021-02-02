package 剑指Offer复习;/* 2021/2/2 11:37 */
/*//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 示例 1:
//
// 输入: [1, 2, 3, 2,  2, 2, 5, 4,  2]
//输出: 2
 */
import org.junit.Test;

import java.util.*;//

public class _39_数组中出现次数超过一半的数字 {//

    @Test
    public void test() {
        System.out.println("hello");
        int res = majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});//2
        System.out.println(res);
    }
    //方法一：HashMap计数法
    //方法二：摩尔计数法（抵消法）/因为是半数
    public int majorityElement(int[] arr) {
        int maj = -1, vote = 0;
        for (int i : arr) {
            if (vote == 0) maj = i;
            vote += (maj == i) ? 1 : -1;
        }
        int count=0;//检验是否数量过半
        for (int i : arr) {
            if (maj==i) count++;
        }
        return (count * 2 > arr.length) ? maj : -1;//过半就输出maj
    }
}
