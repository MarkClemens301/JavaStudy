package 集合框架;/* 2020/9/14 11:06 */

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 基本类型与包装类 {//

    @Test
    public void t() {
        Integer i = new Integer(0);
        System.out.println(i);
    }

    @Test
    public void t1() {
        PriorityQueue<Object> pq = new PriorityQueue<>();
        Arrays.sort(new int[]{1, 5, 2});
    }
}
