package 工具类;/* 2020/8/20 8:59 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //Stream: stream创建 filter转换 count聚合

        int countNull;
        countNull = (int) list.stream()
                .filter(num -> num == null).count();
        System.out.println("countNull = " + countNull);


        //静态创建Stream  of
        Stream iS = Stream.of(1, 2, 3, 5, 3);
        Stream sS = Stream.of("taobao");

        //转换Stream  distinct filter
        String dis = (String) iS.distinct()
                .map(x -> x.toString())
                .collect(Collectors.joining(","));
        //汇聚 count reduce collect
        System.out.println(dis);

        sS.forEach(System.out::println);
    }
}
