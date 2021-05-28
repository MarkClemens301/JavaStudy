package 多线程.原子类;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicIntegerTest {
    /*
    CAS算法
    比synchronized更加高效
    获取、比较、设置
     */
    private static AtomicLong al = new AtomicLong();
    private static AtomicInteger serialNum = new AtomicInteger(5);

    static {
        System.out.println("原数字：" + serialNum + "\n");

        serialNum.set(5);
        System.out.println("自增后（后加加）：" + serialNum.getAndIncrement()); //相当于a++
        serialNum.set(5);
        System.out.println("自增后（前加加）：" + serialNum.incrementAndGet()); //相当于++a

        System.out.println();

        serialNum.set(5);
        System.out.println("自减后（后减减）：" + serialNum.getAndDecrement()); //相当于a--
        serialNum.set(5);
        System.out.println("自减后（前减减）：" + serialNum.decrementAndGet()); //相当于--a
    }

    public static void main(String[] args) {
        System.out.println("多线程/原子类");
        ;
    }

    public void setSerialNum(AtomicInteger serialNum) {
        this.serialNum = serialNum;
    }
}
