package 剑指Offer复习;/* 2020/12/13 23:57 */

import org.junit.Test;

import java.util.Stack;

/*
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true

// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false  // 1 不能在 2 之前弹出。
 */
public class _31_栈的压入_弹出序列 {//给定一个栈的压入序列，判断是否有能产生给定的弹出序列。

    @Test
    public void t() {
        int[] pushed, popped;
        pushed = new int[]{1, 2, 3, 4, 5};
        popped = new int[]{4, 5, 3, 2, 1};//true
        System.out.println(validateStackSequences(pushed, popped));

        pushed = new int[]{1, 2, 3, 4, 5};
        popped = new int[]{4, 3, 5, 1, 2};//false
        System.out.println(validateStackSequences(pushed, popped));
    }

    //模拟法
    public boolean validateStackSequences_(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0; //popped 位置
        for (int num : pushed) {
            st.push(num);
            while (!st.isEmpty() && st.peek().equals(popped[i])) {
                st.pop();
                i++;
            }
        }
        return st.isEmpty();
    }

    //优化：使用数组作为栈，再加一个指针
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length!=popped.length) return false;
        if (pushed.length==0&&popped.length==0) return true;
        int[] st = new int[pushed.length];
        int ip = 0, op = 0;//入栈指针和出栈指针
        for (int num : pushed) {
            st[ip++] = num;
            while (ip > 0 && st[ip - 1] == popped[op]) {
                ip--;
                op++;
            }
        }
        return ip == 0;
    }
}
