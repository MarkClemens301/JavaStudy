package 工具类使用;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ArrayListTest {
    private List<List<Integer>> data = new ArrayList<>(16); //这里初始容量的设置，没有意义
    private int row = 2, col = 3;
    private static final int SEED = 100;
    private Random rd = new Random();

    @Test
    public void test_sort() {
        //测试二维动态数组的存储和更新
        System.out.println("initial size = " + data.size());
        init();
        sets();
        sorts();
        revers();
    }

    public void init() {
        System.out.println("init");
        for (int i = 0; i < row; i++) {
            data.add(new ArrayList<Integer>()); // TODO: 2020/8/3 LIST's 1-D INITIALLY
            for (int j = 0; j < col; j++) {
                data.get(i).add(j, -1); // TODO: 2020/8/3 LIST.GET.ADD
            }
        }
        for (List<Integer> list : data) {
            System.out.println(list);
        }
        System.out.println();
    }

    public void sets() {
        System.out.println("set");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data.get(i).set(j, rd.nextInt(SEED)); // TODO: 2020/8/3 LIST.GET.SET
            }
        }
        for (List<Integer> list : data) {
            System.out.println(list);
        }
        System.out.println();
    }

    public void sorts() {
        System.out.println("sort");
        for (int i = 0; i < row; i++) {
            data.get(i).sort(Integer::compareTo);
            System.out.println(data.get(i));
        }
        System.out.println();
    }

    public void revers() {
        System.out.println("reverse");
        for (int i = 0; i < row; i++) {
            Collections.reverse(data.get(i));
            System.out.println(data.get(i));
        }
        System.out.println();
    }
}
