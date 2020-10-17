package 剑指Offer复习;/* 2020/10/17 23:57 */

import Node.ListNode;

public class _25_合并两个有序链表 {//

    public static void main(String[] args) {
        _25_合并两个有序链表 m = new _25_合并两个有序链表();
        ListNode n1 = new ListNode(new int[]{1, 2, 3});
        ListNode n2 = new ListNode(new int[]{1, 3, 4});
        ListNode mergeList = m.mergeTwoLists(n1, n2);
        System.out.println(mergeList);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), cur = dummy;
        while (l1 != null && l1 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
}
