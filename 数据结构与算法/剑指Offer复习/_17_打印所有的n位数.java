package 剑指Offer复习;/* 2020/9/13 20:10 */

import org.junit.Test;

import java.util.Arrays;

public class _17_打印所有的n位数 {//

    public int[] printAllNumbers(int pos) {//投机取巧了，Math.pow(,)
        double max = Math.pow(10, pos);//10, not 1.
        int[] res = new int[(int) (max - 1)];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    @Test
    public void t() {
        printAllNumbers(2);//test
        printNumbers(1);
        printNumbers(2);
        printNumbers(3);
    }

    int depth, len;

    String printNumbers(int n) {
        StringBuilder sb = new StringBuilder();
        depth = 1;//must global variable
        len = n;
        char[] nums = new char[n];
        dfs(0, 0, nums, sb);
        if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        return sb.toString();
    }

    void dfs(int pos, int count9, char[] nums, StringBuilder sb) {
        if (pos == len) {//最首位,len -- max_depth
            String s = new String(nums).substring(len - depth);
            if (!s.equals("0")) sb.append(s).append(',');
            if (count9 == depth) depth++;
            return;//remember return
        }
        char[] bits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char i : bits) {
            if (i == '9') count9++;
            nums[pos] = i;
            dfs(pos + 1, count9, nums, sb);
        }
        count9--;
    }
}