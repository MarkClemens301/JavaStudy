package 剑指Offer复习;/* 2020/12/21 23:53 */
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
// 返回：
//
// [3,9,20,15,7]
 */

import Node.TreeNode;
import org.junit.Test;

import java.util.*;//

public class _32_1_从上到下打印二叉树 {//

    @Test
    public void t() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);

        int[] arr = levelOrder(root);
        System.out.println(Arrays.toString(arr));
    }

    // TODO: 2020/12/21  树的广度优先搜索 BFS 借助队列
    public int[] levelOrder(TreeNode root) { //in
        if (root == null) return new int[0];

        Queue<TreeNode> q = new LinkedList<>(); //temp
        q.offer(root);
        List<Integer> list = new ArrayList<>(); //out

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                list.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) { //convert
            arr[i] = list.get(i);
        }
        return arr;
        //return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
