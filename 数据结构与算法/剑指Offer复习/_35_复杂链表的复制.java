package 剑指Offer复习;/* 2021/1/6 12:50 */
/*
// 示例 1：
//
//
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// //
////Eg.2
//// 输入：head = [[1,1],[2,1]]
////输出：[[1,1],[2,1]]
////
////
//// 示例 3：
////
////
////
//// 输入：head = [[3,null],[3,0],[3,null]]
////输出：[[3,null],[3,0],[3,null]]
////
////
//// 示例 4：
////
//// 输入：head = []
////输出：[]
////解释：给定的链表为空（空指针），因此返回 null。
 */

import org.junit.Test;

import java.util.*;//

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _35_复杂链表的复制 {//

    /**
     * 本题困难。
     * 解法多种：1.HashMap 2.深搜 3.广搜 4.迭代 5.迭代优化（节点复制）。
     * 重点掌握HashMap和迭代优化两种。
     * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/tong-guo-hashmaplai-shi-xian-by-try-62/
     */
    @Test
    public void test() {
        //head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        System.out.println(copyRandomList(null));
    }

    //todo HashMap法,迭代法；前一种简单
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();

        //copy node
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //copy link
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    // 迭代法(邻居位置复制插入，分离)
    public Node copyRandomList_(Node head) {
        return null;
    }
}
