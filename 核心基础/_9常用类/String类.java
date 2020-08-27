package _9常用类;/* 2020/8/27 23:33 */

import org.junit.Test;

import java.util.*; //import java.io.*;
import java.util.stream.Collectors;

public class String类 {
    @Test
    public void test_same() {
        String s1 = "java";
        String s3 = "javaee";
        String s4 = s1 + "ee"; //javaee
        System.out.println(s3 == "java" + "ee");//true
        System.out.println(s3 == s4); //false
        System.out.println(s3.equals(s4)); //true

        s1 = "not";
        System.out.println(s4); //javaee

        String s5 = s4.intern();
        System.out.println(s5 == s3); //true
        String s6 = s4.intern() + ""; //含有变量，结果就是在堆中
        System.out.println(s6 == s3); //false

        final String s7 = "java";//常量
        System.out.println(s7+"ee" == s3); //true
        final String s8 = s1 + "ee";//存在堆中
        System.out.println(s8 == s3);//false
    }

    @Test
    public void test_split() {
        String s = "Abc";
        s = s.concat("45");
        System.out.println(s);
        String[] ss = s.split("b|4");
        System.out.println(Arrays.stream(ss).collect(Collectors.joining("_")));
    }

    @Test
    public void test_concat() { //只要拼接对象含变量，结果就存堆中。
        String str1 = "123";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";

        System.out.println(str1 == str3);//false
    }
}
