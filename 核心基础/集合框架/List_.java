package 集合框架;/* 2020/9/11 2:20 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class List_ {//

    @Test
    public void t() {
        ArrayList<Object> lis = new ArrayList<>(5);
        lis.add(12);
        System.out.println(lis);
    }

    /**
     * .add 前，初始容量0
     * 默认初始化容量为10，扩容倍率1.5
     * oldC + oldC>>1
     */

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        System.out.println(list);

        LinkedList<Object> llist = new LinkedList<>();
        llist.add(012);
        System.out.println(llist);

        Vector<Integer> vector = new Vector<>();
        vector.add(123);
        System.out.println(vector);
    }
}
