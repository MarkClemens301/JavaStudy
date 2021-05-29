package 剑指Offer复习;/* 2021/2/14 23:01 */
/*
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 输入: [10,2]
//输出: "102"

// 输入: [3,30,34,5,9]
//输出: "3033459"
 */

import org.junit.Test;

import java.util.*;//

public class _45_把数组排成最小的数 {//
    public static void main(String[] args) {
        _45_把数组排成最小的数 m=new _45_把数组排成最小的数();
        m.test();
    }

    @Test
    public void test() {
        System.out.println(minNumber(new int[]
                {1, 2, 5, 12, 26}
        ));
    }

    public String minNumber(int[] nums) {//List.sort
        List<String> sList = new ArrayList<>();
        for (int num : nums) {
            sList.add(String.valueOf(num));
        }
        sList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1)); //key point
        StringBuilder sb = new StringBuilder();
        for (String s : sList) {
            sb.append(s);
        }
        return sb.toString();
    }

    private void fastSort(String[] ss, int L, int R) {//手写快排
        //todo
    }
}

