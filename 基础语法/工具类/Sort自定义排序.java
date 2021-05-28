package 工具类;

import org.junit.Test;

import java.util.*;

public class Sort自定义排序 {
    List<Integer> nums=new ArrayList<>();
    List<String> ss=new ArrayList<>();
    Random r = new Random();

    public Sort自定义排序() {
        for (int i = 0; i < 10; i++) { //todo 随机：添加十个随机整数到动态数组
            nums.add(r.nextInt(15));
        }
        //System.out.println(nums);
        for (int i = 0; i < 10; i++) {
            ss.add(String.valueOf(r.nextInt(25)));
        }
        //System.out.println(ss);
    }

    public static void main(String[] args) {
    }

    @Test
    public void test1() {
        System.out.println(ss);
        ss.sort((x, y) -> (x + y).compareTo(y + x)); //leetcode todo 自定义成递减排序
        System.out.println(ss);
    }

    @Test
    public void test() {
        System.out.println(nums);
        Collections.sort(nums); //add 递增排序
        System.out.println(nums);
        Collections.sort(nums, (x, y) -> (y - x)); //add todo 递增排序
        System.out.println(nums);
    }

}
