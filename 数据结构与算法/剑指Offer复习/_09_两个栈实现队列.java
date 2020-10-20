package 剑指Offer复习;/* 2020/10/20 23:39 */

import java.util.Stack;

public class _09_两个栈实现队列 {//
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public _09_两个栈实现队列() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int num) {
        stack1.push(num);
    }

    public int deleteHead(int num) {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) return stack2.pop();
        else return -1;
    }

    public int peekHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) return stack2.peek();
        else return -1;
    }
}
