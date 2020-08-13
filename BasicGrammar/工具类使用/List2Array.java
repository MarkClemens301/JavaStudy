package 工具类使用;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class List2Array {
    @Test
    public void test() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((double) i);
        }

        System.out.println("Convert List to Array (Double[] double[])");

        //方式一
        Double[] arr = null;
        arr = list.toArray(new Double[0]);//todo list转为array
        System.out.println(Arrays.toString(arr));
        //方式二 to
        double[] arr2 = null;
        arr2 = list.stream().mapToDouble(Double::valueOf).toArray(); //todo list2array
        System.out.println(Arrays.toString(arr2));

        System.out.println("Sort List");

        Arrays.sort(arr, (x, y) -> y.compareTo(x)); //todo 递减排序
        System.out.println(Arrays.toString(arr));

        System.out.println("Find max or min value of a List");

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
    }
}
