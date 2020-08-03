package 工具类使用;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UseArrays {
    private static int[] arr = new int[5]; //静态成员变量

    static { //静态代码块
        for (int i = 0; i < arr.length; i++) arr[i] = i * i;
        System.out.println("初始化静态代码块");
    }

    //public UseArrays() { //类的无参构造器，JUnit要求有无参构造器是公共的，否则就别写。
    //    ;
    //}

    public static void main(String[] args) {
        UseArrays main = new UseArrays();
        System.out.println("RUN");

        //int[] arr = new int[3];
        //for (int i = 0; i < arr.length; i++) arr[i] = i * i;
        System.out.println(main.array2String(main.arr)); // TODO: 2020/8/2  这里改为使用静态成员变量。
    }

    //将数组转化成字符串
    public String array2String(int[] arr) {
        return Arrays.toString(arr);
    }

    /**
     * 以下使用Junit进行测试。
     * 环境配置过程，参考谷歌搜索。
     */
    @Test
    public void test_max() {
        //寻找数组中的最大值、数组的排序
        List<Integer> list = new ArrayList<>();
        for (int num : arr) list.add(num);
        int max = Collections.max(list); //搜索最大值
        System.out.println("max = " + max);
    }
}
