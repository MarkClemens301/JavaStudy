package 剑指Offer复习;/* 2021/2/10 23:11 */
/*
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */

import org.junit.Test;

import java.util.*;//

public class _43_n以内数字出现1的次数 {//

    @Test
    public void test() {
        System.out.println(countDigitOne(12));
    }

    //先用暴力法
    public int countDigitOne(int n) {
        int countOne = 0;
        String s;
        for (int i = 1; i <= n; i++) {
            s = String.valueOf(i);
            for (char c : s.toCharArray()) {
                if ('1' == c) countOne++;
            }
        }
        return countOne;
    }

    public int countDigitOne_(int num) {
        int countOne = 0;
        // TODO: 其他办法
        return countOne;
    }
}
