package 剑指Offer复习;/* 2020/12/24 14:10 */
/*
// 例如:
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
//  [9,20],
//  [15,7]
//]
 */

import Node.ListNode;
import Node.TreeNode;
import org.junit.Test;

import java.util.*;//

public class _32_II_从上到下打印二叉树 {//按层返回

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new LinkedList<>();
        //DFS(root, res, 0);
        BFS(root, res);

        return res;
    }

    private void DFS(TreeNode root, List<List<Integer>> res, int level) {//动态数组的维护，从左至右
        if (root == null) return;

        if (level > res.size() - 1) res.add(new ArrayList<>());
        res.get(level).add(root.val);

        DFS(root.left, res, level + 1);
        DFS(root.right, res, level + 1);

        return;
    }

    private void BFS(TreeNode root, List<List<Integer>> res) {//记录每一层的size!
        if (root == null) return;

        Queue<TreeNode> layer = new LinkedList<>();
        layer.offer(root);
        while (!layer.isEmpty()) {
            int size = layer.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = layer.poll();
                if (node != null) {//
                    nodes.add(node.val);
                    layer.offer(node.left);
                    layer.offer(node.right);
                }
            }
            if (nodes.size() > 0) res.add(nodes);//
        }
        return;
    }
}
