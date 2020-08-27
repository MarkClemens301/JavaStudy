package 工具类;/* 2020/8/26 12:43 */

import java.util.*; //import java.io.*;

public class Comparator_Lambda {
    public static void main(String[] args) {
        Integer[] nums;

        long t1 = System.currentTimeMillis();

        //lambda表达式创建Comparator性能会低一些
        nums = new Integer[]{1, 5, 9, 8, 5, 3, 5, 5, 6, 9};
        Arrays.sort(nums, (x, y) -> (y - x)); //升序排序
        System.out.println(Arrays.toString(nums));

        long t2 = System.currentTimeMillis();
        System.out.println("(t2 - t1) = " + (t2 - t1));

        //普通创建Comparator语句，建议
        nums = new Integer[]{1, 5, 9, 8, 5, 3, 5, 5, 6, 9};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(nums));

        long t3 = System.currentTimeMillis();
        System.out.println("(t3 - t2) = " + (t3 - t2));

        System.out.println("lambda表达式 比普通创建Comparator慢很多！");
    }
}
