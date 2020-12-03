package 剑指Offer复习;/* 2020/12/3 15:51 */

import Node.TreeNode;
import org.junit.Test;

import java.util.*;//

public class _28_对称的二叉树 {//

    @Test
    public void t() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root, root);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && check(s.left, t.right) && check(s.right, t.left);
    }
}
