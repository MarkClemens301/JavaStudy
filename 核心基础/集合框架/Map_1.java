package 集合框架;/* 2020/9/15 0:59 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

public class Map_1 {//

    /**
     * 源码
     * HashMap 的null 处理
     * return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     * 区别：
     * 对null 值的容忍度不一样，HashMap 允许键值均为null, 因为hash 时会进行处理
     * Hashtable 使用fail-safe 机制，读到的数据不一定是最新的数据。
     */
    @Test
    public void t() {
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hash.put(1, 0);
        System.out.println(hash);
    }
}
