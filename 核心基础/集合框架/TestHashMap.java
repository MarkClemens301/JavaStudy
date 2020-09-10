package 集合框架;/* 2020/9/10 17:19 */

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestHashMap {//

    /**
     * HashMap线程不安全，
     * jdk1.8 之后， 数组+链表/红黑树 实现
     * 考点：
     * 加载因子0.75f，扩容倍率2，表容量初始容量16
     * 哈希桶内以"链表"结构存储元素；
     * 表容量大约64且桶元素数量超过8时，该桶采用"红黑树"存储。小于等于6时，红黑树再退化为链表。
     */
    @Test
    public void testHashMap() {
        HashMap<Integer, Integer> map = new HashMap<>();//
        for (int i = 0; i < 5; i++) {
            map.put(i * 10, i);
        }
        System.out.println(map);
    }

    /**
     *
     */
    @Test
    public void testConSyn() {
        Map<Integer, Integer> smap = Collections.synchronizedMap(new HashMap<>());
        smap.put(1, 1);
        smap.put(2, 2);
        System.out.println(smap);
    }
}
