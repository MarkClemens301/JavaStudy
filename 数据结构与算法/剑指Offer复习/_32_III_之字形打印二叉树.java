package 剑指Offer复习;/* 2020/12/26 21:10 */
/*
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
 */

import Node.ListNode;
import Node.TreeNode;
import org.junit.Test;

import java.util.*;//

public class _32_III_之字形打印二叉树 {//

    @Test
    public void t() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>(); // 节点序列容器
        q.offer(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            List<Integer> nodes = new ArrayList<>(); //单层存放

            for (int i = q.size(); i > 0; i--) { //分层功能
                TreeNode node = q.poll();
                if (node != null) {
                    nodes.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if (reverse) Collections.reverse(nodes); //翻转功能  or  if(res.size()%2 == 1) reverse();
            reverse = !reverse;

            if (!nodes.isEmpty()) res.add(nodes);
        }
        return res;
    }
}
