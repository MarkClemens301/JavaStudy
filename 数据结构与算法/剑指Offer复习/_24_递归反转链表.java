package 剑指Offer复习;/* 2020/9/14 1:08 */

import Nodes.ListNode;
import org.junit.Test;

public class _24_递归反转链表 {//

    @Test
    public void t() {
        ListNode head = new ListNode();
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println(head);
        ListNode res = reverseList(head);
        System.out.println(res);
    }

    ListNode reverseList_ori(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode head = reverseList(node.next);//传入尾巴，返回头
        (node.next).next = node;
        (node).next = null;
        return head;//
    }

    ListNode reverseList(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode head = reverseList(node.next);
        (node.next).next = node;
        (node).next = null;
        return head;
    }
}
