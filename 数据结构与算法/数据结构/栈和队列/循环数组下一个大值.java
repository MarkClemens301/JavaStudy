package 数据结构.栈和队列;/* 2020/9/20 23:51 */

import org.junit.Test;
import java.util.Arrays;
import java.util.Stack;

public class 循环数组下一个大值 {//

    @Test
    public void t() {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
        System.out.println(Arrays.toString(nextGreaterElements2(nums)));
    }

    int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];//nums元素大于0
        Arrays.fill(res, -1);

        Stack prePos = new Stack();
        // 栈  将循环数二倍铺平展开，然后用栈辅助查大值
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!prePos.isEmpty() && nums[(int) prePos.peek()] < num) {
                res[(int) prePos.pop()] = num;//
            }
            if (i < n) {
                prePos.push(i);//下一次num 以前的位置
            }
        }
        return res;
    }

    int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> prePos = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!prePos.isEmpty() && nums[prePos.peek()] < num) {
                res[prePos.pop()] = num;
            }
            if (i < n) {
                prePos.push(i);
            }
        }
        return res;
    }
}
