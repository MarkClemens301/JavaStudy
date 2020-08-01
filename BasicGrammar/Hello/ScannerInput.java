package Hello;

import java.util.Scanner;

public class ScannerInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        Scanner是一个扫描器，读取键盘输入到缓冲区
        next读到空白符时结束：空格，制表符，回车
        nextLine读到回车时结束，不要用在其他next之后，否则读入的是空回车。
         */

        //Input a number
        System.out.println("Please input a num. (end with a space or enter)");
        int i = sc.nextInt();
        System.out.println("The number you input is: " + i + ".");
        System.out.println("The cube of the num is: " + Math.pow(i, 3) + ".");

        //Input a sentence
        System.out.println("Please input a sentence.");
        sc.nextLine(); //空回车
        String str = sc.nextLine();
        System.out.println("Your input sentence is: " + str);
    }
}
