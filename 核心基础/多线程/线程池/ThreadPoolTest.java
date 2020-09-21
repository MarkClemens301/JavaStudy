package 多线程.线程池;/* 2020/9/22 1:34 */

import java.util.concurrent.*;

public class ThreadPoolTest {//

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        ExecutorService wordStealingPool = Executors.newWorkStealingPool();
        //Executors创建方式
        //原始创建方式
        ThreadPoolExecutor tp = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }
}
