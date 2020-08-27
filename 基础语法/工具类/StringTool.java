package 工具类;/* 2020/8/23 10:13 */

import org.junit.Test;

import java.util.Arrays;

public class StringTool {
    @Test
    public void test() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 - i;
        }
        String s = Arrays.toString(arr);
        System.out.println("the old: " + s);
        // TODO: 2020/8/23 regex in java:  特殊，尽量避免使用，免得出错
        //  匹配"\"(\\)用\\\\; 匹配"\\"(\\\\)用\\\\\\\\;
        //  匹配数字 用\\d; 匹配"("用\\(
        //s.replaceAll("[\\[,]]", "");
        s = s.replaceAll("[\\[,\\]]", "");
        System.out.println("the new: " + s);
    }

    @Test
    public void test2() {
        String s = "[1,2,3],[4,5,6]";
        int i = 0;
        for (char c : s.toCharArray()) {
            System.out.println("" + i++ + " " + c);
        }
        int id = s.indexOf("],[");
        System.out.println("id = " + id);
        System.out.println(s.substring(0, id));
        System.out.println(s.substring(id + 3));
    }
}
/*
在其他语言中，\\ 表示：我想要在正则表达式中插入一个普通的（字面上的）反斜杠，请不要给它任何特殊的意义。

在 Java 中，\\ 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。

所以，在其他的语言中（如Perl），一个反斜杠 \ 就足以具有转义的作用，
而在 Java 中正则表达式中则需要有两个反斜杠才能被解析为其他语言中的转义作用。
也可以简单的理解在 Java 的正则表达式中，两个 \\ 代表其他语言中的一个 \，
这也就是为什么表示一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\。
 */