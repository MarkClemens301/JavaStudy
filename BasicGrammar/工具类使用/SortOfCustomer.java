package 工具类使用;

import org.junit.Test;

import java.util.*;

public class SortOfCustomer {
    List<Integer> nums=new ArrayList<>();
    Random r = new Random();

    public SortOfCustomer() {
        for (int i = 0; i < 10; i++) { //添加十个随机整数到动态数组
            nums.add(r.nextInt(15));
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
    }

    @Test
    public void test() {
        Collections.sort(nums); //add 递增排序
        System.out.println(nums);
        Collections.sort(nums, (x, y) -> (y - x)); //add 递增排序
        System.out.println(nums);
    }

}
