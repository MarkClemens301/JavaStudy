package LeetCode每日一题.简单;/* 2020/10/28 10:34 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class _3_无重复字符的最长子串 {//

    @Test
    public void t() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {//滑动窗口
        if (s == null || s.length() < 1) return 0;
        char[] cc = s.toCharArray();
        int left = 0, right = 0, n = s.length(), maxLength = 1;
        for (int i = 0; i < n; i++) {
            Set set = new HashSet();
            for (int j = i; j < n; j++) {
                if (!set.add(s.charAt(i)) && maxLength < set.size()) {
                    maxLength = set.size();
                    break;
                }
            }
        }
        return maxLength;
    }
}
