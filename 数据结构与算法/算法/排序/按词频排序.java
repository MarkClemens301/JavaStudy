/* 2020/9/5 10:44 */
package 算法.排序;/* 2020/9/5 10:44 */

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 按词频排序 {
    @Test
    public void test() {
        String res = frequencySort("aadcddedeeeedsddde");
        System.out.println(res);
    }

    public String frequencySort(String s) {
        /*map 统计词频，优先队列 排序*/
        StringBuilder sb = new StringBuilder();
        //统计词频
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, 1 + freq.getOrDefault(c, 0));
        }
        //排序!!
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (freq.get(o1)==freq.get(o2)) return (char) o1 - (char) o2;
                return -(freq.get(o1) - freq.get(o2));
            }
        };
        PriorityQueue<Character> pq = new PriorityQueue<Character>(com);
        for (Character c : freq.keySet()) {
            pq.offer(c);//key
        }
        //收集
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = freq.get(c);
            while (count-->0) sb.append(c);
        }
        return sb.toString();
    }
}
