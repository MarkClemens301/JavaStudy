package 工具类使用;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    /*
    CAS算法
    比synchronized更加高效
    获取、比较、设置
     */
    private static AtomicInteger serialNum = new AtomicInteger(10);

    static {
        System.out.println("原数字：" + serialNum);
        serialNum.getAndIncrement(); //相当于a++
        System.out.println("自增后：" + serialNum);

    }

    public static void main(String[] args) {
        ;
    }

    public void setSerialNum(AtomicInteger serialNum) {
        this.serialNum = serialNum;
    }
}
