package 多线程.线程通信1;/* 2020/9/10 23:22 */

public class WaitNotify {//创建、生命周期、同步机制
    /**
     * wait 线程等待，进入阻塞状态
     * 直至另一个线程调用 notify, 可令其继续执行。
     * 典型应用：生产者-消费者模式  资源缺失时，消费者调用.wait()自我阻塞，生产者生产完毕后调用.notify()/.All 唤醒消费者。
     */

    /**
     * 线程状态 6
     * NEW          新建态     线程被定义
     * RUNNABLE     就绪/运行  调用.start 后就进入此状态
     * BLOCKED      阻塞态     线程等待进入（或调用wait后等待重新进入）"synchronized 方法或代码块"，等待获取锁
     * WAITING      等待态     .wait/.join 使自己陷入等待，释放锁，等待其他线程做出特定操作（.notify 或 中断）  阻塞！
     * TIME_WAITING 限时等待    .sleep(timeout)/.wait(timeout) 使自己进入超时等待，超时后自动返回  阻塞！
     * TERMINATED   终止状态    线程运行结束
     *
     * 新建到就绪：.start  ||  运行到就绪 .yield
     * （运行中途）引发阻塞：.wait .sleep .join //.suspend //等待同步锁
     * 结束阻塞（进入就绪）：.join 结束 .wait结束 .sleep 到点 .notify .notifyAll //.resume //获取同步锁
     */

    /**
     * 备注: Lock类对于锁的实现，不会令线程进入阻塞状态；而是进入等待状态。 LockSupport.park();
     * .notify 唤醒第一个wait 的线程 .notifyAll 唤醒所有wait 的线程
     * 但是.notify 不释放锁！
     */

}
