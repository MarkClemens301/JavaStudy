package com.mark.job.review.jvm;

import java.util.Arrays;

/**
 * @author ThinKPad
 */
public class ExpressionCalc {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        /*
        操作数栈  [1]
        局部变量表  i自增 i:2  i被赋值--> i:1
         */

        int j = i++;
        /*
        操作数栈  [1]
        局部变量表  i自增 i:2  j被赋值--> j:1
         */
        int k = i + ++i * i++;

        /*
        操作数栈  [2 + 3 * 3] --> [2 + 9] --> [11]
        局部变量表  i自增 i:3  i自增 i:4  被赋值--> j:11
         */
        System.out.println("{i,j,k} = " + Arrays.toString(new int[]{i, j, k}));
        // 4, 1 ,11
    }
}
