package 剑指Offer复习;/* 2020/11/1 23:58 */

import Nodes.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class _27_二叉树的镜像 {//
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("TEST");
    }

    @Test
    public void t() {
        System.out.println("test");
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(root);
        System.out.println(mirrorTree(root));//4-27-1369 //4-72-9631
        System.out.println(mirrorTreeIter(root));
    }

    TreeNode mirrorTree(TreeNode root) {//递归
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    TreeNode mirrorTreeIter(TreeNode root) {//辅助栈
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node.left);//save
                stack.push(node.right);
                TreeNode tmp = node.left;//swap
                node.left = node.right;
                node.right = tmp;
            }
        }
        return root;
    }
}
