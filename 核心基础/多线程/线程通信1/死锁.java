package 多线程.线程通信1;/* 2020/9/11 0:56 */

public class 死锁 {//

    /**
     * 死锁时，所有线程都处于阻塞态，没有提示。
     * 不同的线程分别占用对方需要的同步资源，都在等待对方释放需要的资源，结果就是都不能释放（死锁）。
     */

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        //Thread0
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                synchronized (sb1) {//同时要拿两个锁sb1 sb2, 死锁
                    sb1.append('a');
                    sb2.append(1);///这时候sb2可能被锁住了
                    System.out.println(Thread.currentThread().getName() + "--" + sb1);
                    System.out.println(Thread.currentThread().getName() + "--" + sb2);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb2) {///这时候sb2也可能已经被锁住了
                        sb1.append('b');
                        sb2.append(2);
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        };

        //Thread1 继承Thread 重写run 方法   直接调用.start
        //new Thread() {
        //    @Override
        //    public void run() {
        //        synchronized (sb2) {
        //            System.out.println(Thread.currentThread().getName());
        //            sb1.append('c');//同时要拿两个锁sb1 sb2, 死锁
        //            sb2.append(3);
        //            System.out.println(Thread.currentThread().getName() + "--" + sb1);
        //            System.out.println(Thread.currentThread().getName() + "--" + sb2);
        //            try {
        //                Thread.sleep(100);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            synchronized (sb1) {
        //                sb1.append('d');
        //                sb2.append(4);
        //                System.out.println(sb1);
        //                System.out.println(sb2);
        //            }
        //        }
        //    }
        //}.start();

        //Thread1 也可以通过：实现Runnable 接口和run 方法
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                synchronized (sb2) {
                    sb1.append('c');
                    sb2.append(3);
                    System.out.println(Thread.currentThread().getName() + "--" + sb1);
                    System.out.println(Thread.currentThread().getName() + "--" + sb2);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb1) {
                        sb1.append('d');
                        sb2.append(4);
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        });

        //先后启动线程
        thread0.start();
        thread1.start();
    }
}
