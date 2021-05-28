package 多线程.线程同步的通信;/* 2020/9/24 2:06 */

public class 三线程交替打印ABC {//
    static volatile int pos = 1;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread a = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (pos == 1) {
                        lock.notifyAll();
                        System.out.print("A");
                        pos = 2;
                        try {
                            Thread.sleep(300);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread b = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (pos == 2) {
                        lock.notifyAll();
                        System.out.print("B");
                        pos = 3;
                        try {
                            Thread.sleep(300);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread c = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (pos == 3) {
                        lock.notifyAll();
                        System.out.print("C");
                        pos = 1;
                        try {
                            Thread.sleep(300);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }
}
