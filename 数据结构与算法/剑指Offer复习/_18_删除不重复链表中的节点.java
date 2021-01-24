package 剑指Offer复习;/* 2020/10/23 22:39 */

import Nodes.ListNode;
import org.junit.Test;
/*
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
 */
public class _18_删除不重复链表中的节点 {//
    @Test
    public void t() {
        int[] nums = {4, 5, 1, 9};
        System.out.println(deleteNode(new ListNode(nums), 5));
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head==null || head.val == val) return head;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {//&&
            pre = pre.next;
            cur = cur.next;
        }
        if(cur!=null) pre.next = cur.next;//if cur matched, then delete cur
        return head;
    }
}
