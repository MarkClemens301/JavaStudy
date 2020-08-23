package 工具类;/* 2020/8/23 10:13 */

import org.junit.Test;

import java.util.Arrays;

public class StringTool {
    @Test
    public void test() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 - i;
        }
        String s = Arrays.toString(arr);
        System.out.println("the old: " + s);
        // TODO: 2020/8/23 regex in java:  特殊，尽量避免使用，免得出错
        //  匹配"\"用\\\\; 匹配"\\"用\\\\\\\\;
        //  匹配数字 用\\d; 匹配"("用\\(
        //s.replaceAll("[\\[,]]", "");
        s = s.replaceAll("[\\[,\\]]", "");
        System.out.println("the new: " + s);
    }
}
