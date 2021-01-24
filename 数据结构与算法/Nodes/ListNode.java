package Nodes;/* 2020/9/9 1:24 */

public class ListNode {
    public int val = 0;
    public ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] ints) {//constructor
        if(ints == null || ints.length<1) return;
        ListNode cur = new ListNode(ints[0]);
        ListNode head = cur;
        for (int i = 1; i < ints.length; i++) {
            cur.next = new ListNode(ints[i]);
            cur = cur.next;
        }
        this.val = head.val;
        this.next = head.next;
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
