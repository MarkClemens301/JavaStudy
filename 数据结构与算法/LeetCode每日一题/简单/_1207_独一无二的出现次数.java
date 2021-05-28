package LeetCode每日一题.简单;/* 2020/10/28 10:15 */

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_独一无二的出现次数 {//
    @Test
    public void t() {//vxv
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueOccurrences(new int[]{1, 2}));
        System.out.println(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        //map提取频率，set判断重复
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if(!map.containsKey(i)) map.put(i,0);
            map.put(i, map.get(i) + 1);
        }
        Set<Integer> set=new HashSet<>();
        for (Integer freq : map.values()) {
            if(set.contains(freq)) return false;//重复
            else set.add(freq);
        }
        return true;
        //return map.size() == new HashSet(map.values()).size();//次数不重复，true
    }
}