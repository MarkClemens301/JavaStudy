package 剑指Offer复习;/* 2020/9/13 20:10 */

import org.junit.Test;

public class _17_打印所有的n位数 {//

    public StringBuilder printAllNumbers(int pos) {//投机取巧了，pow
        double max = Math.pow(1, pos);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < max; i++) {
            sb.append(i).append(",");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb;
    }

    @Test
    public void t() {
        printAllNumbers(2);//test
        printNumbers(1);
        printNumbers(2);
        printNumbers(3);
    }

    StringBuilder sb;
    char[] nums;
    int len, size;//len为最大的长度，size可变长度
    char[] bits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    String printNumbers(int n) {
        sb = new StringBuilder();
        nums = new char[n];
        len = n;
        size = 1;//
        //全排列
        dfs(0, 0);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb + "\n");//
        return sb.toString();
    }

    void dfs(int pos, int nine) {
        if (pos == len) {
            String s = new String(nums).substring(len - size);
            if (!s.equals("0")) sb.append(s).append(',');
            if (nine == size) size++;//9 99 999 ..
            return;//递归一定不要忘了
        }
        for (char bit : bits) {
            if (bit == '9') nine++;//本轮循环只发生一次
            nums[pos] = bit;
            dfs(pos + 1, nine);
        }
        nine--;//循环后复原
    }
}
