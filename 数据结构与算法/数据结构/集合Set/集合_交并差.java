package 数据结构.集合Set;/* 2020/9/7 3:35 */

import org.junit.Test;

import java.util.*;//

public class 集合_交并差 {
    private Set<Integer> set1, set2, set;

    public 集合_交并差() {
        System.out.println("Constructor");
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set = new HashSet<>();

        set1.addAll(Arrays.asList(1, 2, 3, 5));
        set2.addAll(Arrays.asList(2, 3, 4));
        System.out.println(set1);
        System.out.println(set2);
    }

    /*
    集合居然没有.intersection() 方法？？ 还是得自己写啊。
     */
    @Test
    public void 交集() {
        //new 集合_交并差();
        set.addAll(set1);
        set.retainAll(set2);
        System.out.println("InterSection: " + set);//2 3
    }

    @Test
    public void 并集() {
        set.addAll(set1);
        set.addAll(set2);
        System.out.println("UnionSet: " + set);//1 2 3 4 5
    }

    @Test
    public void 差集() {
        set.addAll(set1);
        set.removeAll(set2);
        System.out.println("DifferentSet: " + set);//1 5
    }

    @Test
    public void 测试() {
        交集();
        并集();
        差集();
    }
}
