package 剑指Offer复习;/* 2020/11/1 23:58 */

import Node.TreeNode;
import org.junit.Test;

public class _27_二叉树的镜像 {//

    @Test
    public void t() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(mirrorTree(root));
    }

    TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
