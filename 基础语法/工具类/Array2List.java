package 工具类;/* 2020/8/28 18:58 */

import org.junit.Test;

import java.util.*; //import java.io.*;

public class Array2List {
    @Test
    public void test() {
        //存入基本数据类型的数组，不太方便使用
        List<int[]> ls = Arrays.asList(new int[]{1, 23, 4});
        System.out.println("ls.get(0)[0] = " + ls.get(0)[0]);

        //存入对象数组，good
        List<Integer> ls2 = Arrays.asList(new Integer[]{1, 23, 4});
        System.out.println("ls2 = " + ls2);
        System.out.println("max = " + Collections.max(ls2));
    }
}
