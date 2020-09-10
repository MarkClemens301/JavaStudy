package 多线程.线程通信1;/* 2020/9/10 23:22 */

import java.util.concurrent.TimeUnit;

public class WaitNotify {//创建、生命周期、同步机制  //同步监视器==锁
    /**
     * wait 线程进入等待，进入阻塞状态；直至另一个线程调用 notify, 可令其有机会继续执行。
     * 典型应用：生产者-消费者模式  资源缺失时，消费者调用.wait()自我阻塞，生产者生产完毕后调用.notify()/.All 唤醒消费者。
     */

    /**
     * 线程状态 6
     * NEW          新建态     线程被定义
     * RUNNABLE     就绪/运行  调用.start 后就进入此状态  【lock.ReadyQueue】锁下面挂都了几个线程队列
     * BLOCKED      阻塞态     线程等待进入（或调用wait后等待重新进入）"synchronized 方法或代码块"，等待获取锁，阻塞态让出了CPU执行权！！
     * WAITING      等待态     .wait/.join 使自己陷入等待，释放锁，等待其他线程做出特定操作（lock.notify 或 中断）  阻塞！ 【lock.WaitingQueue】
     * TIME_WAITING 限时等待    .sleep(timeout)/.wait(timeout) 使自己进入超时等待，超时后自动返回  阻塞！
     * TERMINATED   终止状态    线程运行结束，或称DEAD
     *
     * 还有一种分类法：NEW RUNNABLE RUNNING BLOCKED TERMINATED
     *
     * 新建到就绪：.start  ||  运行到就绪 .yield(用的非常少，启发式)
     * （运行中途）引发阻塞：.wait .sleep .join //.suspend //等待同步锁
     * 结束阻塞（进入就绪）：.join 结束 .wait结束 .sleep 到点 .notify .notifyAll //.resume //获取同步锁
     */

    /**
     * 备注: Lock类对于锁的实现，不会令线程进入阻塞状态；而是进入等待状态。 LockSupport.park();
     * .notify 唤醒第一个wait 的线程 .notifyAll 唤醒所有wait 的线程
     * 但是.notify 不释放锁！
     * <p>
     * .sleep 属于Thread 类，线程不会释放锁，阻塞，让出CPU给其他线程；
     * .wait 属于Object 类，线程会释放锁，阻塞。
     */

    private static final Object obj = new Object();
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread produce = new Thread(new Produce());
        Thread consume = new Thread(new Comsume());
        System.out.println("消费者先启动，生产者后启动");
        consume.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        produce.start();

        //TODO 上面先让consume.wait 下面让produce.notify  实现同步：consume->produce->consume
        try {
            System.out.println("\n先join生产者线程，后join消费者线程");
            produce.join();//先进行完
            consume.join();//后进行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //生产者线程
    static class Produce implements Runnable {//static 便于main 调用

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("\n0.进入生产者线程");
                try {
                    System.out.println("1.开始生产");
                    TimeUnit.MILLISECONDS.sleep(200);
                    System.out.println("2.生产完毕");
                    flag = true;
                    obj.notify();//通知消费者
                    System.out.println("2.1 我已结束生产  通知其他线程，但不释放锁，继续进行  (调用.notify)");
                    TimeUnit.MILLISECONDS.sleep(100);//模拟其他消耗
                    System.out.println("3.退出生产者线程");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者线程
    static class Comsume implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("\n-进入消费者线程");
                System.out.println("-wait flag: " + flag);
                while (!flag) {
                    try {
                        System.out.println("-flag==false: 还没生产；释放锁，开始等待！！  (调用.wait)");
                        obj.wait();//阻塞~等待~
                        System.out.println("-wait flag: " + flag);
                        System.out.println("-收到消息，并等生产者线程运行结束 后：结束消费者的等待、准备消费  (被唤醒，.wait结束)");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("-开始消费");
                try {
                    TimeUnit.MILLISECONDS.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-消费完毕，消费线程结束");
            }
        }
    }
}
