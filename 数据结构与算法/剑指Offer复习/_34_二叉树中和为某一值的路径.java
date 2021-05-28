package 剑指Offer复习;/* 2021/1/4 23:46 */
/*
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
 */

import Nodes.TreeNode;
import org.junit.Test;

import java.util.*;//

public class _34_二叉树中和为某一值的路径 {//难题，递归、每条路径向下看

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);

        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }

    List<List<Integer>> res = new ArrayList<>();//所有符合要求的路径
    LinkedList<Integer> path = new LinkedList<>();//单条路径

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    private void recur(TreeNode root, int sum) {
        if (root == null) return;
        path.add(root.val);//A
        sum -= root.val; //子路径的目标sum
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));// 深拷贝
        }
        //每个节点都分出两个路径
        recur(root.left, sum);
        recur(root.right, sum);
        path.removeLast();//B 回溯之前
    }
}
