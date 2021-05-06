import org.junit.Test;

import java.util.Arrays;
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

    @Test
    public void test2() {
        int[] nums = {1, 0, 2, 4, 3};
        sortInplace(nums);
        System.out.println(Arrays.toString(nums));
    }

    public boolean PRINT = true;

    public void sortInplace(int[] nums) { // 原地排序
        if (nums == null || nums.length < 2) return;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) { // num 不在 id 位置
                int id = nums[i];
                if (PRINT) System.out.println("" + nums[i] + ',' + nums[id]);
                nums[i] = nums[id];
                nums[id] = id;
            }
            if (PRINT) System.out.println();
        }
    }
}
