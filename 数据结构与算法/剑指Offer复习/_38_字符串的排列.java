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

    public String[] permutation(String s) {//排列 main
        res = new LinkedList<>();
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    public void dfs(int x) {//回溯，注意剪枝
        if (x == chars.length - 1) {// len-1 位置已经用set筛选过了 不必担心重复
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(x, i);//把第i个位置上的元素放到前面位置x上去
            dfs(x + 1);
            swap(x, i);
        }
    }

    public void swap(int x, int y) {//字符位置交换
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }
}
