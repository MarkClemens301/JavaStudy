package 剑指Offer复习;/* 2020/10/23 22:14 */

import Nodes.ListNode;
import org.junit.Test;

/*
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5.
 */
public class _22_链表中的倒数第k个节点 {//

    @Test
    public void test() {
        ListNode node = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(getKthFromEnd(node, 2));
        System.out.println(getKthFromEnd(node, 6));
        System.out.println(getKthFromEnd(node, 5));
    }

    public ListNode getKthFromEnd(ListNode node, int k) {//1 2 3 4 5, 2
        ListNode p1 = node, p2 = node;
        for (int i = 0; i < k; i++) {//先行k step
            if (p2 == null) return null;//输入不对，无法满足
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
