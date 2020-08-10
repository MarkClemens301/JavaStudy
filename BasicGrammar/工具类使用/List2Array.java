package 工具类使用;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List2Array {
    @Test
    public void test() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((double) i);
        }
        Double[] arr = null;
        arr = list.toArray(new Double[0]);//todo list转为array

        System.out.println(Arrays.toString(arr));
    }
}
