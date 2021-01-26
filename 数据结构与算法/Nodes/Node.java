package Nodes;/* 2021/1/26 23:31 */

import org.junit.Test;

import java.util.*;//


// Definition for a Node.
public class Node {
    public int val;//为了能直接调用属性。
    public Node next;
    public Node random;

    public static void main(String[] args) {
        System.out.println(new Node(1));
        System.out.println("Test class, need and only a public zero-argument constructor");
    }

    public Node() {
        this.val = 0;
    }

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
        System.out.println("place:"+place);
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