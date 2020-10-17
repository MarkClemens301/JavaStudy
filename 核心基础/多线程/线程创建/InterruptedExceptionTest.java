package 多线程.线程创建;/* 2020/10/16 17:32 */

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * thread.interrupt();
 * while(!interrupted()){} //通过 判断中断状态 决定是否继续无限循环
 */
public class InterruptedExceptionTest {//

    public static void main(String[] args) {//抛出 throws InterruptedException
        Thread myThread = new MyThread();
        myThread.start();//启动该线程
        Thread myThread1 = new MyThread();
        myThread1.start();
        myThread.interrupt();//中断该线程，调用该线程的中断函数sddsdssdd
        System.out.println("Main run");
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100);//
                System.out.println(Thread.currentThread().getName() + " run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void t() {
        Thread myThread4 = new MyThread4();
        myThread4.start();
        myThread4.interrupt();
    }

    public static class MyThread4 extends Thread {
        @Override
        public void run() {
            AtomicInteger aInt = new AtomicInteger();
            while (!interrupted()) {
                aInt.incrementAndGet();//endless loop
            }
            System.out.println(aInt);
            System.out.println(Thread.currentThread().getName() + " run");
        }
    }
}
