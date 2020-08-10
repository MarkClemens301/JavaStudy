package 工具类使用;

import org.junit.Test;

import java.util.*;

public class UseArraysTool {
    private static int[] arr = new int[5]; //静态成员变量
    private Random r = new Random();

    static { //静态代码块
        for (int i = 0; i < arr.length; i++) arr[i] = i * i;
        System.out.println("初始化静态代码块");
    }

    //public UseArrays() { //类的无参构造器，JUnit要求有无参构造器是公共的，否则就别写。
    //    ;
    //}

    public static void main(String[] args) {
        UseArraysTool main = new UseArraysTool();
        System.out.println("RUN");

        //int[] arr = new int[3];
        //for (int i = 0; i < arr.length; i++) arr[i] = i * i;
        System.out.println(main.array2String(main.arr)); // TODO: 2020/8/2  这里改为使用静态成员变量。
    }

    //将数组转化成字符串
    public String array2String(int[] arr) { //数组2字符串
        return Arrays.toString(arr);
    }

    /**
     * 以下使用Junit进行测试。
     * 环境配置过程，参考谷歌搜索。
     */

    @Test
    public void test1() { //队列 优先队列 堆（数据结构）
        Queue<Integer> quque = new PriorityQueue<>((x, y) -> (y - x)); //小根堆改为大根堆的写法，需要用到java8新特性：lambda表达式
        //Queue<Integer> quque = new PriorityQueue<>(); //默认为小根堆
        //存入堆中
        for (int i = 0; i < 10; i++) {
            int val = r.nextInt(10); //产生10以内的随机数（整数）
            System.out.print(val + " ");
            quque.offer(val);
        }
        System.out.println();
        //排序（利用小根堆）
        int size = quque.size();
        for (int i = 0; i < size; i++) {
            System.out.print(quque.poll() + " ");
        }
        System.out.println();
    }

    @Test
    public void test_max() { //数组最大值、数组排序
        List<Integer> list = new ArrayList<>();
        for (int num : arr) list.add(num);
        int max = Collections.max(list); //搜索最大值
        //Collections.sort(list); //自然排序
        System.out.println("max = " + max);
    }
}
