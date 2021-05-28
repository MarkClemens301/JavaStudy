package 多线程.线程池;/* 2020/10/2 23:19 */

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

public class MarkFutureTask<V> implements Runnable {
    MarkCallable<V> callable;//包装业务代码
    V result;//业务执行结果
    volatile String state = "NEW";
    //集合 【消费者】 存储等待的线程
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    public MarkFutureTask(MarkCallable<V> callable) {
        this.callable = callable;
    }

    /* 异步线程 */
    @Override
    public void run() {
        try {
            this.result = callable.call();//赋值  生产者
        } catch (Exception e) {
            e.printStackTrace();
            state = "ERROR";//
        } finally {
            state = "DONE";
            Thread waiter = waiters.poll();
            while (waiter != null) {
                LockSupport.unpark(waiter);
                waiter = waiters.poll();
            }
        }
    }

    /* 主线程 -- 获取结果 */
    public V get() throws Exception {/* 如果没有执行完毕，则进入等待*/
        /*
        使用【生产者消费者模式】实现多线程等待，
        让一个线程进入等待，
        线程状态（6个）K：
        NEW RUNNABLE BLOCKED WAITING TIME_WAITED TERMINATED
        */
        Thread thread = Thread.currentThread();
        while (!"DONE".equals(state)) {
            //Thread.sleep(100);//会影响效率
            waiters.offer(thread);
            LockSupport.park();//消费者 等待
        }
        return result;//消费者
    }
}
