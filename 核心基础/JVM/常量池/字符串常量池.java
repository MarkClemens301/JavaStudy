package JVM.常量池;/* 2020/9/10 16:20 */

public class 字符串常量池 {//

    public static String _a = "a";

    public static void main(String[] args) {
        String _b = "b";
        String _c = new String("c");
        String _d = _c.intern();

        //String AB = "_a_" + new String("_b_");
        //System.out.println(AB+"_c_");//编译之后，有常量_a_和_b_，没有_a__b_（在堆中还是运行时再生成？）
    }
}
/*
反编译工具（自带）
TODO
 javap -verbose .\核心基础\target\classes\JVM\常量池\字符串常量池.class
*/
/*
反编译结果
Classfile /D:/ProgramData/_Code_root/java/JavaPro/LeetCode/target/classes/JavaCore.JVM/常量池/TestString.class
  Last modified 2020-8-23; size 694 bytes
  MD5 checksum 3bcc323fb25ad15f4aa9222db26af93a
  Compiled from "TestString.java"
public class JavaCore.JVM.常量池.TestString
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #10.#30        // java/lang/Object."<init>":()V
   #2 = String             #31            // b
   #3 = Class              #32            // java/lang/String
   #4 = String             #33            // c
   #5 = Methodref          #3.#34         // java/lang/String."<init>":(Ljava/lang/String;)V
   #6 = Methodref          #3.#35         // java/lang/String.intern:()Ljava/lang/String;
   #7 = String             #36            // a
   #8 = Fieldref           #9.#37         // JavaCore.JVM/常量池/TestString._a:Ljava/lang/String;
   #9 = Class              #38            // JavaCore.JVM/常量池/TestString
  #10 = Class              #39            // java/lang/Object
  #11 = Utf8               _a
  #12 = Utf8               Ljava/lang/String;
  #13 = Utf8               <init>
  #14 = Utf8               ()V
  #15 = Utf8               Code
  #16 = Utf8               LineNumberTable
  #17 = Utf8               LocalVariableTable
  #18 = Utf8               this
  #19 = Utf8               LJVM/常量池/TestString;
  #20 = Utf8               main
  #21 = Utf8               ([Ljava/lang/String;)V
  #22 = Utf8               args
  #23 = Utf8               [Ljava/lang/String;
  #24 = Utf8               _b
  #25 = Utf8               _c
  #26 = Utf8               _d
  #27 = Utf8               <clinit>
  #28 = Utf8               SourceFile
  #29 = Utf8               TestString.java
  #30 = NameAndType        #13:#14        // "<init>":()V
  #31 = Utf8               b
  #32 = Utf8               java/lang/String
  #33 = Utf8               c
  #34 = NameAndType        #13:#40        // "<init>":(Ljava/lang/String;)V
  #35 = NameAndType        #41:#42        // intern:()Ljava/lang/String;
  #36 = Utf8               a
  #37 = NameAndType        #11:#12        // _a:Ljava/lang/String;
  #38 = Utf8               JavaCore.JVM/常量池/TestString
  #39 = Utf8               java/lang/Object
  #40 = Utf8               (Ljava/lang/String;)V
  #41 = Utf8               intern
  #42 = Utf8               ()Ljava/lang/String;
{
  public static java.lang.String _a;
...
 */
