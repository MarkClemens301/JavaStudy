package 工具类;/* 2020/8/20 8:59 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamTool {
    @Test
    public void test_count_null() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(3);
        list.add(4);
        list.add(null);
        list.add(6);
        //stream创建 filter转换 count聚合

        int countNull = (int) list.stream().filter(num -> num == null).count();
        System.out.println("countNull = " + countNull);
    }
}
