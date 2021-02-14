package 剑指Offer复习;/* 2021/2/14 21:20 */
/*
//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。
//
// 请写一个函数，求任意第n位对应的数字。
 */

import org.junit.Test;

import java.util.*;//

public class _44_数字序列中的第n位数 {//[难题]

    @Test
    public void ts() {
        System.out.println(findNthDigit(9));//9
        System.out.println(findNthDigit(11));//0
        System.out.println(findNthDigit(19));//4
        System.out.println(12);
        System.out.println(findNthDigit(14));//1
        System.out.println(findNthDigit(15));//2
    }

    //迭代，找规律，不断缩小n
    public int findNthDigit(int n) {
        //[1] 0 [9] 1--9 [90] 10-99 [900] 100-999 ...
        if (n <= 9) return n;
        long bit = 1, pow = 1, step = 9;
        n -= 1;//TODO!! -[step=1]"0"

        while (n > step) {
            n -= step;//走完【step】后，还剩多少步
            pow *= 10;//下一段的基数
            bit += 1;//下一段每个数的位数长度
            step = 9 * pow * bit;//eg. 9*10*2bit
        }

        long num = pow + n / bit;//2. find num
        int place = (int) (n % bit);
        return String.valueOf(num).charAt(place) - '0';
    }
}
