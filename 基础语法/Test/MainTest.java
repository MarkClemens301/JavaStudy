package Test;


//package main
//注意不要添加包名称，否则会报错。

import java.util.*;

class Test {
}

public class MainTest {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while (cin.hasNextInt()) {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }
    }
}