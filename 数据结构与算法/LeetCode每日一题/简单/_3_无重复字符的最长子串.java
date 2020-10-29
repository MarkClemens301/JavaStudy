package LeetCode每日一题.简单;/* 2020/10/28 10:34 */

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_无重复字符的最长子串 {//

    @Test
    public void t() {//3 1 3 /2 3
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("bwf"));
    }

    public int lengthOfLongestSubstring0(String s) {//滑动窗口 O(n^2)
        if (s == null || s.length() < 1) return 0;
        int n = s.length(), maxLength = 0;
        for (int i = 0; i < n; i++) {
            Set set = new HashSet();
            for (int j = i; j < n; j++) {
                if (maxLength > n-i || !set.add(s.charAt(j))) break;
                maxLength = Math.max(set.size(), maxLength);
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {//O(n) 记录字符的最近位置
        if (s == null || s.length() < 1) return 0;
        int n = s.length(), maxLength = 0, lastPos = -1;
        Map map = new HashMap();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                int pos = (int) map.get(s.charAt(i));
                lastPos = Math.max(lastPos, pos);//可能有多个段重复字符，取最近位置
            }
            maxLength = Math.max(maxLength, i - lastPos);
            map.put(s.charAt(i), i);
        }
        return maxLength;
    }
}
