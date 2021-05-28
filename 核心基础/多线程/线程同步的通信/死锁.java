package 多线程.线程同步的通信;/* 2020/9/11 0:56 */

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
/*
解除死锁的办法
1. 打破互斥条件（允许同时访问某些资源）：但打印机等资源是无法被同时访问，这由资源本身决定了。此方法无实用价值。

2. 打破不可抢占条件（可抢占）：某个进程占有某些资源，又申请新的资源，但无法被立即满足时，它必须释放占有的所有资源，以后再重新申请。
即该进程占有的资源被隐蔽地抢占了。该方法实现起来困难。

3. 打破占有且申请（资源预先分配策略）：进程在运行前一次性地向系统申请它所需要的所有资源，如无法满足，则不分配任何资源，暂不运行。这确保运行的进程不会发生死锁。
缺点是：
a.进程的执行是动态不可预测的，难以预知他需要的全部资源。
b.资源利用率低下，进程获取到所有所需资源才开始运行，即便某些资源只使用一次，但也会全程占用，造成极大的资源浪费。
c.降低了并发性，资源有限，而且还存在浪费，能分配到全部资源的进程数较少。

4. 打破循环等待条件（资源有序分配策略）：对资源预先编号，按号分配，使得进程在申请和占用资源时不形成环路。线程对资源的占用必须按照资源号递增的顺序提出。
即进程占用了小号资源才能申请大号资源，就不会产生环路，预防死锁。相比预分配策略，这种策略使得资源利用率和系统吞吐量都有很大提高。
缺点：
a.限制了进程对资源的请求，且为系统中资源进行合理地编号的难度也较大，会增加系统开销。
b.为了遵循编号次序递增的申请原则，暂不使用的资源也会提前申请，增加了进程对资源的占用时间。

回顾：
打破互斥（允许同时访问）、打破不可抢占（可抢占/强制释放）、打破占有且申请（预先分配策略）、打破循环等待（有序分配策略）

死锁的避免：
安全序列
银行家算法（进程申请资源相当于客户向银行家贷款，为保证资金安全，几条规定...）
 */