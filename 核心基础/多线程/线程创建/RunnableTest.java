/* 2020/9/6 10:45 */
package 多线程.线程创建;/* 2020/9/6 10:45 */
/*
多线程实例
 */
public class RunnableTest {
    public static void main(String args[]) throws InterruptedException {
        Thread.currentThread().setPriority(3);//main Thread
        MyThread1 mt = new MyThread1();
        Thread td1 = new Thread(mt);
        Thread td2 = new Thread(mt);
        Thread td3 = new Thread(mt);
        //Settings
        td1.setName("Thread1");
        td2.setName("Thread2");
        td3.setName("Thread3");
        td1.setPriority(5);//default/
        td2.setPriority(10);//fastest+ MAX_PRIORITY
        td3.setPriority(1);//slowest-
        td1.join(10);
        //Runnable/Running(After get CPU)
        td1.start();
        td2.start();
        td3.start();
    }
}

class MyThread1 implements Runnable {
    public static volatile int count = 0;//
    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                System.out.println(Thread.currentThread().getName() +
                        ":" + Thread.currentThread().getPriority() +
                        ":i=" + i +
                        "--" + count++);
            }
        }
    }
}
