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

    @Override
    public String toString() {
        List<String> res = new ArrayList<>();
        Map<Integer, Integer> place = new HashMap<>();
        // record random place 【map】
        Node cur = this;
        int i = 0;
        while (cur != null) {
            place.put(cur.val, i++);
            cur = cur.next;
        }
        System.out.println(place);
        // output val and random 【String.format(,,)】
        cur = this;
        while (cur != null) {
            String randOrder;// random指针所指向的节点位置序号
            if (cur.random != null) {
                randOrder = String.valueOf(place.get(cur.random.val));
            } else {
                randOrder = "null";
            }
            res.add(String.format("[%s,%s]", cur.val, randOrder));
            cur = cur.next;
        }
        return res.toString();
    }
}

public class _35_复杂链表的复制 {//

    /*
     * {1=4, 7=0, 10=3, 11=2, 13=1} [[7,null], [13,0], [11,4], [10,2], [1,0]]
     */
    // 生成示例一
    @Deprecated
    public Node genRandomList1() {
        // head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node head = new Node(7);
        // 0
        Node cur = head;
        cur.next = new Node(13);
        cur.random = null;
        // 1
        cur = cur.next;
        cur.next = new Node(11);
        cur.random = head;
        // 2
        cur = cur.next;
        cur.next = new Node(10);
        // cur.random = head;
        // 3
        cur = cur.next;
        cur.next = new Node(1);
        cur.random = head.next.next;
        // 4
        cur = cur.next;
        cur.next = null;
        cur.random = head;
        // 2r
        head.next.next.random = cur;
        return head;
    }

    /*
     * {1=0, 2=1} [[1,1], [2,1]]
     */
    // 生成示例二
    @Deprecated
    public Node genRandomList2() {
        // head = [[1,1],[2,1]]
        Node head = new Node(1);
        // 0
        Node cur = head;
        cur.next = new Node(2);
        // 1
        cur = cur.next;
        cur.next = null;
        cur.random = cur;
        // 0r
        head.random = cur;
        return head;
    }

    /**
     * 本题困难。 解法多种：1.HashMap 2.深搜 3.广搜 4.迭代 5.迭代优化（节点复制）。 重点掌握HashMap和迭代优化两种。
     * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/tong-guo-hashmaplai-shi-xian-by-try-62/
     */
    @Test
    public void test() {
        Node head;
        head = genRandomList1();
        System.out.println(copyRandomList(head));
        head = genRandomList2();
        System.out.println(copyRandomList(head));
    }

    // todo HashMap法,迭代法；前一种简单
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();

        // copy node
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // copy link
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    // 2.迭代法(邻居位置复制插入，分离)
    public Node copyRandomList_(Node head) {
        if (head == null) {
            return null;
        }
        // val next
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        // random
        cur = head;
        while (cur != null) {
            cur.next.random = (cur.random != null) ? cur.random.next : null;
            cur = cur.next.next;
        }
        // depart
        Node newHead = head.next;
        cur = head;
        Node newCur = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            newCur.next = (newCur.next != null) ? newCur.next.next : null;
            newCur = newCur.next;
        }
        return newHead;
    }
}
