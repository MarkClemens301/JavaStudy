package 多线程;/* 2020/10/16 15:05 */

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Hello {//

    @Test
    public void t1() throws Exception {//线程的创建、使用
        Boolean aBoolean = new Boolean(true);//"true"
        AtomicInteger aInt = new AtomicInteger();//原子类
        System.out.println(aInt);
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
        aInt.decrementAndGet();
    }

    @Test
    public void t2() throws InterruptedException {//Daemon 线程
        AtomicLong aLong = new AtomicLong();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    aLong.addAndGet(i);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1);//1ms
        System.out.println(aLong.get());
    }
}
