package 集合框架;/* 2020/9/15 0:59 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

public class Map_1 {//

    /**
     * 源码
     * HashMap 的null 处理
     * return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     */
    @Test
    public void t() {
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hash.put(1, 0);
        System.out.println(hash);
    }
}
