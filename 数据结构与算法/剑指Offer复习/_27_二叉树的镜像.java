package 剑指Offer复习;/* 2020/11/1 23:58 */

import Node.TreeNode;

public class _27_二叉树的镜像 {//

    TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
