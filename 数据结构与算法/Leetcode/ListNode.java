package Leetcode;/* 2020/9/9 1:24 */

public class ListNode {
    public int val = 0;
    public ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            sb.append(head.val).append(',');
            head = head.next;
        }
        if (this != null) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
