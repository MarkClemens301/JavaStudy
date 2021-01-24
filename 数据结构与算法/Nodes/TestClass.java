package Nodes;/* 2020/9/9 1:31 */

import org.junit.Test;

public class TestClass {
    @Test
    public void test() {
        ListNode listNode = new ListNode();
        System.out.println(listNode.val);

        listNode = new ListNode(10);
        System.out.println(listNode.val);

        TreeNode treeNode = new TreeNode();
        System.out.println(treeNode.val);
    }
}
