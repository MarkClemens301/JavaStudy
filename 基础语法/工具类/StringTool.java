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
        s.replaceAll("[],]", "");
        System.out.println("the new: " + s);
    }
}
