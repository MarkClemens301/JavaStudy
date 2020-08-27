package _9常用类;/* 2020/8/27 23:33 */

import org.junit.Test;

import java.util.*; //import java.io.*;
import java.util.stream.Collectors;

public class String类 {
    @Test
    public void test2() {
        String s = "Abc";
        s = s.concat("45");
        System.out.println(s);
        String[] ss = s.split("b|4");
        System.out.println(Arrays.stream(ss).collect(Collectors.joining("_")));
    }

    @Test
    public void test1(){
        String str1 = "123";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";

        System.out.println(str1 == str3);//false
    }
}
