package 剑指Offer复习;/* 2021/2/1 23:54 */
/*
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
 */

import org.junit.Test;

import java.util.*;//

public class _38_字符串的排列 {//

    @Test
    public void t() {
        String[] res;
        res = permutation("abc");
        System.out.println(Arrays.toString(res));
        res = permutation("abcb");
        System.out.println(Arrays.toString(res));
    }


    List<String> res;//结果存储
    char[] chars;//回溯容器

    public String[] permutation(String s) {//main 全排列
        res = new LinkedList<>();
        chars = s.toCharArray();

        dfs(0);//首位开始全排列过程

        return res.toArray(new String[0]);//list2arr
    }

    public void dfs(int x) {//dfs回溯，剪枝处理
        //同一位置不能放不同的字符，但是'a'不能放两次：：set的作用
        if (x == chars.length - 1) {
            res.add(String.valueOf(chars));//到达最后一位，直接存结果；经过剪枝判断才到这里的
        }
        //剪枝容器
        HashSet<Character> set = new HashSet<>();
        //回溯
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);

            swap(x, i);
            dfs(x + 1);//走下一位
            swap(x, i);
        }
    }

    public void swap(int x, int y) {//两个位置的字符对换
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }
}
