package 剑指Offer复习;/* 2020/12/15 15:51 */

import org.junit.Test;

import java.util.Stack;

/*
思路一：每次调用min() 遍历求min_num
思路二：添加单调栈，非严格降序地添加最小值
 */
public class _30_包含min函数的栈 {//
    Stack<Integer> stackA = new Stack<>();
    Stack<Integer> stackB = new Stack<>();//辅助栈，非严格递减

    public int peek() {
        if (stackA.isEmpty()) return -1;
        return stackA.peek();
    }

    public void push(int num) {
        if (stackA.isEmpty()) {
            stackA.push(num);
            stackB.push(num);
            return;
        }
        stackA.push(num);
        if (!stackB.isEmpty() && num <= stackB.peek()) {
            stackB.push(num);
        }
    }

    public int pop() {
        if (stackA.isEmpty()) return -1;
        int top = stackA.pop();
        if (stackB.peek() == top) stackB.pop();
        return top;
    }

    public int get_min() {
        if (stackB.isEmpty()){ return -1;}
        return stackB.pop();
    }

    public void min() {
        System.out.println(get_min());
    }

    @Test
    public void t() {
        _30_包含min函数的栈 st = new _30_包含min函数的栈();
        st.push(-2);
        st.push(0);
        st.push(-3);
        st.min();
        st.pop();
        System.out.println(st.peek());
        st.min();
    }
}