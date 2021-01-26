package 剑指Offer复习;/* 2021/1/21 2:49 */
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
/*
Tree
     4
    / \
  2    5
 / \
1  3

DoublyList
1 2 3 4 5
 */

import Nodes.TreeNode;
import org.junit.Test;

import java.util.*;//

public class _36_二叉搜索树与双向链表 {//

    @Test
    public void t() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        System.out.println("_36_二叉搜索树与双向链表.t");
        System.out.println(root);
        TreeNode loopList = treeToDoubleList(root);
        //输出（元素不重复）循环列表
        if (loopList == null) return;
        int initVal = loopList.val;
        do {
            System.out.print(loopList.val + ", ");
            loopList = loopList.right;
        } while (loopList.val != initVal);
        System.out.println();
    }

    TreeNode head, pre;//pre用于记录双向链表中位于cur左侧的节点

    public TreeNode treeToDoubleList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;//形成环
        pre.right = head;
        return head;
    }

    public void dfs(TreeNode cur) {//todo【难题】 dfs 二叉搜索树的中序遍历为递增序列。
        if (cur == null) {
            return;
        }
        dfs(cur.left);

        //todo 任务部分比较难理解  | 因为已经是按中序遍历了，所以只需考虑将pre和cur做好连接。
        //if (head == null) head = cur; /*递归最深处，最左叶子节点为链表的头节点*/
        if (pre == null) head = cur; //pre==null, 即cur左侧没有节点，则cur为头结点
        else pre.right = cur;//反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作

        cur.left = pre;
        pre = cur;//pre右移至cur，也包括初始的null移动至cur

        dfs(cur.right);
        return;
    }

}
