package 剑指Offer复习;/* 2021/1/21 2:49 */
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
import Nodes.TreeNode;
import org.junit.Test;

import java.util.*;//

public class _36_二叉搜索树与双向链表 {//
    @Test
    public void t() {
        System.out.println("_36_二叉搜索树与双向链表.t");
    }
    
    TreeNode head, pre;

    public TreeNode treeToDoubleList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(TreeNode root) {//todo【难题】 dfs 二叉搜索树的中序遍历为递增序列。
        if (root == null) {
            return;
        }
        dfs(root.left);
        //todo 任务部分比较难理解

        dfs(root.right);
        return;
    }

}
