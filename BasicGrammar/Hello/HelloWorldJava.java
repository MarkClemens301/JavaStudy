package Hello;

import org.junit.Test;

public class HelloWorldJava {
    public static void main(String[] args) {
        System.out.println("This is a Java Script.");  //print

        HelloWorldJava hello = new HelloWorldJava();  //new instance
        hello.test1();

        long time = hello.timePoint();
        System.out.println("Current time point: " + time);  //system time point
    }

    @Test
    public void test1() {
        System.out.println("这是一个测试程序，支持中文！");
    }

    public long timePoint() {
        long time = System.currentTimeMillis();  //返回长整型
        return time;
    }
}
