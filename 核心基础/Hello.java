import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Hello {//

    public static void main(String[] args) {
        new Object();
    }

    @Test
    public void t1() {
        Object obj = new Object();
        synchronized (obj) {
            obj = new String("213");
        }
        new ReentrantReadWriteLock();//读写锁、非独占式
        new ReentrantLock();//可重入锁、独占式
        new CyclicBarrier(2);//内存屏障  +1直到指定值 可循环利用
        new CountDownLatch(2);//闭锁  -1直到0
    }
}
