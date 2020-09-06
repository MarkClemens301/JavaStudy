/* 2020/9/6 10:45 */
package 线程创建;/* 2020/9/6 10:45 */

import java.util.*; //import java.io.*;

public class ThreadTest {
    public static void main(String[] args) {
        //my
        MyThread mt = new MyThread();//
        System.out.println(mt.getName());
        mt.start();
        //main
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        thread.setPriority(1);//优先级更高，概率意义上的。 1~10
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                System.out.println(thread.getName()
                        + ":" + thread.getPriority()
                        + ":" + i);
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("super.run()");
        super.run();
        System.out.println("my run()");
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                System.out.println(getName() +
                        ":" + getPriority() +
                        ":" + i);
            }
        }
    }
}