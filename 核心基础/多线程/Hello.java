package 多线程;/* 2020/10/16 15:05 */

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Hello {//

    @Test
    public void t1() throws Exception {
        AtomicInteger aInt = new AtomicInteger();//原子类
        //1. Thread
        class MyThread extends Thread {
            public void run() {
                aInt.incrementAndGet();
                System.out.println(aInt.get());
            }
        }
        new MyThread().start();//
        //2. Runnable
        new Thread(new Runnable() {
            @Override
            public void run() {
                aInt.incrementAndGet();
                System.out.println(aInt);
            }
        }).start();//W
        //3. Callable
        FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                aInt.incrementAndGet();
                return aInt.get();
            }
        });
        new Thread(ft).start();//
        System.out.println(ft.get());
    }
}
