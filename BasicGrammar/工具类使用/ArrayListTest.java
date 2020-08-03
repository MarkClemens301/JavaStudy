package 工具类使用;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListTest {
    private List<List<Integer>> data = new ArrayList<>();
    private static final int SEED = 100;
    private Random rd = new Random();

    public void init() {
        for (int i = 0; i < 5; i++) {
            data.add(new ArrayList<Integer>());
            for (int j = 0; j < 3; j++) {
                data.get(i).add(j, 10);
            }
        }
    }

    @Test
    public void test_sort() {
        //测试二维动态数组的存储和更新
        init();
        for (List<Integer> list : data) System.out.println(list);
        System.out.println();
        sets();
        for (List<Integer> list : data) System.out.println(list);
    }

    public void sets() {
        for (int i = 0; i < 5; i++) for (int j = 0; j < 3; j++) data.get(i).set(j, rd.nextInt(SEED));
    }
}
