package 集合框架;/* 2020/9/14 11:06 */

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 基本类型与包装类 {//

    /**
     * 包装类
     * 基本数据类型 int4 char2 byte1
     */
    @Test
    public void tWrapperClass() {
        Integer i = new Integer(0);//整型常量池，-128~127
        System.out.println(i);
    }

    /**
     * 优先队列
     */
    @Test
    public void tPriorityQueue() {
        PriorityQueue<Object> pq = new PriorityQueue<>();
        Arrays.sort(new int[]{1, 5, 2});
    }
}
