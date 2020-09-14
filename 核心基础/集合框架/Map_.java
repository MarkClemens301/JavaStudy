package 集合框架;/* 2020/9/10 17:19 */

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Map_ {//

    /**
     * HashMap线程不安全，
     * jdk1.8 之后， 数组+链表/红黑树 实现
     * 考点：
     * 加载因子0.75f，扩容倍率2，表容量初始容量16
     * 哈希桶内以"链表"结构存储元素；
     * 表容量大约64且桶元素数量超过8时，该桶采用"红黑树"存储。小于等于6时，红黑树再退化为链表。
     */
    @Test
    public void testHashMap() {//线程不安全：HashMap();
        HashMap<Integer, Integer> map = new HashMap<>();//
        for (int i = 0; i < 5; i++) {
            map.put(i * 10, i);
        }
        System.out.println(map);
    }

    /**
     *
     */
    @Test
    public void testConSyn() {//线程安全：Hashtable(); Collections.synchronizedMap(map);
        //C.s
        smap.put(1, 1);
        smap.put(2, 2);
        System.out.println(smap);
        //Hashtable
        tmap.put(0, 0);
        System.out.println(tmap);
        //多线程测试
        MyThread thread = new MyThread();
        Thread thA = new Thread(thread);
    }

    static Map<Integer, Integer> smap = Collections.synchronizedMap(new HashMap<>());
    static Hashtable<Integer, Integer> tmap = new Hashtable<>();

    // TODO: 2020/9/10 线程安全的Hashtable 和ConcurrentHashMap 还不知道怎么测试？？
    public static void main(String[] args) {
        Thread thA = new Thread() {
            @Override
            public void run() {
                System.out.println("A开始执行");
                for (int i = 0; i < 10; i++) {
                    tmap.put(i, i * 100);
                    System.out.println(Thread.currentThread().getName() + ":" + i + ":" + tmap.get(i));
                    //try {
                    //    Thread.sleep(100);
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                    //if (i == 5) {
                    //    tmap.notify();
                    //}
                }
            }
        };
        Thread thB = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (tmap.size() == 5) {
                        //try {
                        //    tmap.wait();
                        //} catch (InterruptedException e) {
                        //    e.printStackTrace();
                        //}
                        System.out.println("B开始执行");
                        for (int i = 20; i < 22; i++) {
                            tmap.put(i, i * 10);
                            System.out.println(Thread.currentThread().getName() + ":" + i + ":" + tmap.get(i));
                        }
                        break;
                    }
                }
            }
        };
        thA.setName("ThreadA");
        thB.setName("ThreadB");
        thB.start();
        thA.start();
    }

    class MyThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                tmap.put(i, i * 10);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + smap.get(i));
                if (i == 3) {
                    //notify();
                    try {
                        //Map_.this.wait();//释放锁
                        tmap.wait();//释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
